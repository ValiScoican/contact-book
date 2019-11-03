<template>
  <div class="add container">
    <Alert v-if="alert" v-bind:message="alert" />
    <h1 class="page-header">Add Contact</h1>

    <form v-on:submit="addContact">
        <div class="well">
            <div class="form-group">
                <label>First Name</label>
                <input type="text" class="form-control" placeholder="First Name" v-model="contact.firstName">
            </div>
            <div class="form-group">
                <label>Last Name</label>
                <input type="text" class="form-control" placeholder="Last Name" v-model="contact.lastName">
            </div>
            <div class="form-group">
                <label>Phone</label>
                <input type="text" class="form-control" placeholder="Phone" v-model="contact.phoneNumber">
            </div>
            <div class="form-group">
                <label>Address</label>
                <input type="text" class="form-control" placeholder="Address" v-model="contact.address">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <br>
        <br>
        <br>
    </form>
  </div>
</template>

<script>
    import Alert from './Alert'
    export default {
    name: 'add',
    data () {
        return {
        contact: {},
        alert:''
        }
    },
    methods: {
        addContact(e){
            if(!this.contact.firstName || !this.contact.lastName || !this.contact.phoneNumber){
                this.alert = 'Please fill in all required fields';
            } else if (!/^\d+$/.test(this.contact.phoneNumber)) {
                this.alert = 'Invalid phone number!';
            } else {
                let newContact = {
                    firstName: this.contact.firstName,
                    lastName: this.contact.lastName,
                    phoneNumber: this.contact.phoneNumber,
                    address: this.contact.address,
                }
                
                fetch('http://localhost:8080/contact/add', {
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                        },
                    body: JSON.stringify(newContact)
                }).then(response => {
                    this.$router.push({path: '/', query: {alert: 'Contact added'}});    
                    console.log(response)
                })

                e.preventDefault();
            }
            e.preventDefault();
        }
    },
    components: {
        Alert
    }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
