const { createApp } = Vue;
createApp({
    data() {
        return {
            data:[],
            externAccount:"",
            ownAccount:"",
            amount:"",
            description:""
        }
    },
    created() {
      this.loadData()
  },
    methods: {
        loadData(){
          axios.get('http://localhost:8080/api/clients/current')
          .then(response => {
              this.data = response.data
              this.accounts = this.data.accounts
              this.accounts1 = this.data.accounts[0]
              this.accounts2 = this.data.accounts[2]
            //   this.cuentas = this.data.accounts
            //   this.prestamos = this.data.loans
              console.log(this.data)
              console.log(this.accounts)
            //   console.log(this.cuentas)
            //   console.log(this.prestamos)
          })
          .catch(err => console.log(err))
        },
        newTransfer() {
            axios.post('/api/clients/current/transactions',`amount=${this.amount}&description=${this.description}&numberOrigin=${this.ownAccount}&numberDestiny=${this.externAccount}`)
                .then(response => { 
                    console.log(response.data)
                    Swal.fire(
                        response.data,
                        'You have created a transaction!',
                        'success'
                      )
                    console.log("transaction")
                    console.log(response.data)
                    
                    
                })
                .catch(err =>{
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: err.response.data,
                      })
                console.error(err);
                this.error = "failed to create transaction. Please try again!"    
            });     
        },
    }

})
.mount('#app')

var ownAccountFields = document.getElementById("own_account_fields");
var thirdPartyFields = document.getElementById("third_party_fields");

document.getElementById("own_account").addEventListener("click", function() {
  ownAccountFields.style.display = "block";
  thirdPartyFields.style.display = "none";
});

document.getElementById("third_party").addEventListener("click", function() {
  ownAccountFields.style.display = "none";
  thirdPartyFields.style.display = "block";
});

document.querySelector("form").addEventListener("submit", function(e) {
  e.preventDefault();
  var transferType = document.querySelector('input[name="transfer_type"]:checked').value;
  if (transferType === "own_account") {
    var destinationAccount = document.getElementById("destination_account").value;
    if (destinationAccount === "") {
      alert("Selecciona una cuenta de destino");
      return false;
    }
  } else if (transferType === "third_party") {
    var accountNumber = document.getElementById("account_number").value;
    if (accountNumber === "") {
      alert("Ingresa el número de cuenta");
      return false;
    }
  } else {
    alert("Selecciona un tipo de transferencia");
    return false;
  }
  alert("Transferencia enviada");
  return true;
});