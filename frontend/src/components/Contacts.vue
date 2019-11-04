


<template>
  <div class="contacts container">
    <Alert v-if="alert" v-bind:message="alert" />
    <h1 class="page-header">Manage Contacts</h1>
    <input class="form-control" placeholder="Enter First Name or Last Name" v-model="filterInput">
    <br />
    <table class="table table-striped">
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone Number</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="contact in filterBy(contacts, filterInput)">
            <td>{{contact.firstName}}</td>
            <td>{{contact.lastName}}</td>
            <td>{{contact.phoneNumber}}</td>
            <td><router-link class="btn btn-default" v-bind:to="'/contact/' + contact.id">View</router-link></td>
          </tr>
        </tbody>
    </table>
    <button class="btn btn-light" v-if="currentPage > 0" v-on:click="handlePaginationButton(false)">Back</button>    
    <button class="btn btn-light" v-if="contacts.length === pageLimit" v-on:click="handlePaginationButton(true)">Next</button>
  </div>
</template>

<script>
  import Alert from './Alert';
  export default {
    name: 'contacts',
    data () {
      return {
        contacts: [],
        alert:'',
        filterInput:'',
        currentPage: 0,
        pageLimit: 5,
      }
    },
    methods: {
      fetchContacts(){
        fetch(`http://localhost:8080/contacts?page=${this.currentPage}&limit=${this.pageLimit}`)
          .then(response => {
            if (response.status !== 200) {
              this.alert = 'Please log in!!!!';
            }
            return response.json();
          })
          .then(data => {
            this.contacts = data;
          }).catch(e => {
          })
      },
      filterBy(list, value){
        value = value.charAt(0).toUpperCase() + value.slice(1); 
        return list.filter(function(contact){
          return contact.lastName.indexOf(value) > -1 || contact.firstName.indexOf(value) > -1;
        });
      },
      handlePaginationButton(isNext) {
        if (isNext) {
          this.currentPage++;
        } else {
          this.currentPage--;
        }
        this.fetchContacts();
      }
    },
    created: function(){
      if(this.$route.query.alert){
        this.alert = this.$route.query.alert;
      }
      this.fetchContacts();
    },
    updated: function(){
      // this.fetchContacts();
    },
    components: {
      Alert
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
