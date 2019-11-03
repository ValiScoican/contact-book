<template>
  <div class="edit container">
    <Alert v-if="alert" v-bind:message="alert" />
    <h1 class="page-header">Edit Contact</h1>
    <form v-on:submit="updateContact">
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
        fetchContact(id){
            fetch(`http://localhost:8080/contact?contactId=${id}`)
                .then(response => response.json())
                .then(data => {
                    this.contact = data;
                })
        },
        updateContact(e){
            if(!this.contact.firstName || !this.contact.lastName){
                this.alert = 'Please fill in all required fields';
            } else if (!/^\d+$/.test(this.contact.phoneNumber)) {
                this.alert = 'Invalid phone number!';
            } else {
                let updContact = {
                    firstName: this.contact.firstName,
                    lastName: this.contact.lastName,
                    phoneNumber: this.contact.phoneNumber,
                    address: this.contact.address
                }

                fetch('http://localhost:8080/contact/update/' + this.$route.params.id, {
                    method: 'PUT',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                        },
                    body: JSON.stringify(updContact)
                }).then(respone => {
                    this.$router.push({path: '/', query: {alert: 'Contact updated'}});    
                })

                e.preventDefault();
            }
            e.preventDefault();
        }
    },
    created: function(){
        this.fetchContact(this.$route.params.id);
    },
    components:{
        Alert
    }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
