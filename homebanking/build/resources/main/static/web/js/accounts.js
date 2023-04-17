const { createApp } = Vue;
const app = createApp({
    data() {
        return {
            data: [],
            cuentas:[],
            prestamos:[],
        }
    },
    created() {
        axios.get('http://localhost:8080/api/clients/2')
            .then(response => {
                this.data = response.data
                this.cuentas = this.data.accounts
                this.prestamos = this.data.loans
                console.log(this.data)
                console.log(this.cuentas)
                console.log(this.prestamos)
            })
            .catch(err => console.log(err))
    },
});
        
    

app.mount('#appAccounts')