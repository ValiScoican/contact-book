<template>
  <div class="details container">
    <router-link to="/">Back</router-link>
    <h1 class="page-header">{{contact.firstName}} {{contact.lastName}}
        <span class="pull-right">
            <router-link class="btn btn-primary" v-bind:to="'/edit/'+contact.id">Edit</router-link>
            <button class="btn btn-danger" v-on:click="deleteContact(contact.id)">Delete</button>
            </span>
    </h1>
    <ul class="list-group">
            <li class="list-group-item"><span class="glyphicon glyphicon-phone" aria-hidden="true"></span> {{contact.phoneNumber}}</li>
            <li class="list-group-item">{{contact.firstName}}</li>
            <li class="list-group-item">{{contact.lastName}}</li>
            
        </ul>
  </div>
</template>

<script>
export default {
  name: 'contactdetails',
  data () {
    return {
      contact: ''
    }
  },
  methods:{
      fetchContact(id){
        fetch(`http://localhost:8080/contact?contactId=${id}`)
          .then(response => response.json())
          .then(data => {
            this.contact = data;
          })
      },
      deleteContact(id){
        fetch(`http://localhost:8080/contact/${id}`, {
           method: 'DELETE',
        })
          .then(response => {
            this.$router.push({path: '/', query: {alert: 'Contact deleted'}});
          })
      }
  },
  created: function(){
      this.fetchContact(this.$route.params.id);
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
