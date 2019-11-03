webpackJsonp([1,0],[function(t,e,a){(function(t){"use strict";function e(t){return t&&t.__esModule?t:{default:t}}var n=a(38),s=e(n),o=a(23),r=(e(o),a(37)),c=e(r),i=a(36),l=e(i),u=a(27),d=e(u),p=a(24),v=e(p),f=a(25),m=e(f),h=a(28),_=e(h),b=a(26),N=e(b);s.default.use(l.default),s.default.use(c.default);var g=new c.default({mode:"history",base:t,routes:[{path:"/",component:d.default},{path:"/about",component:v.default},{path:"/add",component:m.default},{path:"/Contact/:id",component:N.default},{path:"/edit/:id",component:_.default}]});new s.default({router:g,template:'\n    <div id="app">\n      <nav class="navbar navbar-default ">\n      <div class="container">\n        <div class="navbar-header">\n          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">\n            <span class="sr-only">Toggle navigation</span>\n            <span class="icon-bar"></span>\n            <span class="icon-bar"></span>\n            <span class="icon-bar"></span>\n          </button>\n          <a class="navbar-brand" href="/">Phone Book</a>\n        </div>\n        <div id="navbar" class="collapse navbar-collapse">\n          <ul class="nav navbar-nav">\n            <li><router-link to="/">Home</router-link></li>\n            <li><router-link to="/about">About</router-link></li>\n            <li><a href="/logout">Logout</a></li>\n          </ul>\n          <ul class="nav navbar-nav navbar-right">\n            <li><router-link to="/add">Add Contanct</router-link></li>\n          </ul>\n        </div><!--/.nav-collapse -->\n      </div>\n    </nav>\n      <router-view></router-view>\n    </div>\n  '}).$mount("#app")}).call(e,"/")},,function(t,e,a){a(15);var n=a(1)(a(7),a(31),"data-v-0ea354e6",null);t.exports=n.exports},,function(t,e){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={name:"app",components:{}}},function(t,e){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={name:"about",data:function(){return{}}}},function(t,e,a){"use strict";function n(t){return t&&t.__esModule?t:{default:t}}Object.defineProperty(e,"__esModule",{value:!0});var s=a(3),o=n(s),r=a(2),c=n(r);e.default={name:"add",data:function(){return{contact:{},alert:""}},methods:{addContact:function(t){var e=this;if(this.contact.firstName&&this.contact.lastName&&this.contact.phoneNumber)if(/^\d+$/.test(this.contact.phoneNumber)){var a={firstName:this.contact.firstName,lastName:this.contact.lastName,phoneNumber:this.contact.phoneNumber,address:this.contact.address};fetch("http://localhost:8080/contact/add",{method:"POST",headers:{Accept:"application/json","Content-Type":"application/json"},body:(0,o.default)(a)}).then(function(t){e.$router.push({path:"/",query:{alert:"Contact added"}}),console.log(t)}),t.preventDefault()}else this.alert="Invalid phone number!";else this.alert="Please fill in all required fields";t.preventDefault()}},components:{Alert:c.default}}},function(t,e){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={name:"alert",props:["message"],data:function(){return{}}}},function(t,e){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={name:"contactdetails",data:function(){return{contact:""}},methods:{fetchContact:function(t){var e=this;fetch("http://localhost:8080/contact?contactId="+t).then(function(t){return t.json()}).then(function(t){e.contact=t})},deleteContact:function(t){var e=this;fetch("http://localhost:8080/contact/"+t,{method:"DELETE"}).then(function(t){e.$router.push({path:"/",query:{alert:"Contact deleted"}})})}},created:function(){this.fetchContact(this.$route.params.id)}}},function(t,e,a){"use strict";function n(t){return t&&t.__esModule?t:{default:t}}Object.defineProperty(e,"__esModule",{value:!0});var s=a(2),o=n(s);e.default={name:"contacts",data:function(){return{contacts:[],alert:"",filterInput:""}},methods:{fetchContacts:function(){var t=this;fetch("http://localhost:8080/contacts").then(function(e){return 200!==e.status&&(t.alert="Please log in!!!!"),e.json()}).then(function(e){t.contacts=e}).catch(function(t){})},filterBy:function(t,e){return e=e.charAt(0).toUpperCase()+e.slice(1),t.filter(function(t){return t.lastName.indexOf(e)>-1||t.firstName.indexOf(e)>-1})}},created:function(){this.$route.query.alert&&(this.alert=this.$route.query.alert),this.fetchContacts()},updated:function(){},components:{Alert:o.default}}},function(t,e,a){"use strict";function n(t){return t&&t.__esModule?t:{default:t}}Object.defineProperty(e,"__esModule",{value:!0});var s=a(3),o=n(s),r=a(2),c=n(r);e.default={name:"add",data:function(){return{contact:{},alert:""}},methods:{fetchContact:function(t){var e=this;fetch("http://localhost:8080/contact?contactId="+t).then(function(t){return t.json()}).then(function(t){e.contact=t})},updateContact:function(t){var e=this;if(this.contact.firstName&&this.contact.lastName)if(/^\d+$/.test(this.contact.phoneNumber)){var a={firstName:this.contact.firstName,lastName:this.contact.lastName,phoneNumber:this.contact.phoneNumber,address:this.contact.address};fetch("http://localhost:8080/contact/update/"+this.$route.params.id,{method:"PUT",headers:{Accept:"application/json","Content-Type":"application/json"},body:(0,o.default)(a)}).then(function(t){e.$router.push({path:"/",query:{alert:"Contact updated"}})}),t.preventDefault()}else this.alert="Invalid phone number!";else this.alert="Please fill in all required fields";t.preventDefault()}},created:function(){this.fetchContact(this.$route.params.id)},components:{Alert:c.default}}},,,function(t,e){},function(t,e){},function(t,e){},function(t,e){},function(t,e){},function(t,e){},function(t,e){},,,,function(t,e,a){a(17);var n=a(1)(a(4),a(33),null,null);t.exports=n.exports},function(t,e,a){a(13);var n=a(1)(a(5),a(29),"data-v-00012184",null);t.exports=n.exports},function(t,e,a){a(19);var n=a(1)(a(6),a(35),"data-v-ca6ba6dc",null);t.exports=n.exports},function(t,e,a){a(14);var n=a(1)(a(8),a(30),"data-v-0207b821",null);t.exports=n.exports},function(t,e,a){a(16);var n=a(1)(a(9),a(32),"data-v-0efbb732",null);t.exports=n.exports},function(t,e,a){a(18);var n=a(1)(a(10),a(34),"data-v-6a420ce9",null);t.exports=n.exports},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement;t._self._c||e;return t._m(0)},staticRenderFns:[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"about container"},[a("h1",{staticClass:"page-header"},[t._v("About")]),t._v(" "),a("p",[t._v("This is a phonebook manager app built with the Vue.js framework")]),t._v(" "),a("p",[t._v("Created by "),a("b",[t._v("Vali Scoican")])]),t._v(" "),a("p",[t._v("Version 1.0.0")])])}]}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"details container"},[a("router-link",{attrs:{to:"/"}},[t._v("Back")]),t._v(" "),a("h1",{staticClass:"page-header"},[t._v(t._s(t.contact.firstName)+" "+t._s(t.contact.lastName)+"\n      "),a("span",{staticClass:"pull-right"},[a("router-link",{staticClass:"btn btn-primary",attrs:{to:"/edit/"+t.contact.id}},[t._v("Edit")]),t._v(" "),a("button",{staticClass:"btn btn-danger",on:{click:function(e){return t.deleteContact(t.contact.id)}}},[t._v("Delete")])],1)]),t._v(" "),a("ul",{staticClass:"list-group"},[a("li",{staticClass:"list-group-item"},[a("span",{staticClass:"glyphicon glyphicon-phone",attrs:{"aria-hidden":"true"}}),t._v(" "+t._s(t.contact.phoneNumber))]),t._v(" "),a("li",{staticClass:"list-group-item"},[t._v(t._s(t.contact.firstName))]),t._v(" "),a("li",{staticClass:"list-group-item"},[t._v(t._s(t.contact.lastName))])])],1)},staticRenderFns:[]}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"alert alert-warning alert-dismissible",attrs:{role:"alert"}},[t._m(0),t._v("\n    "+t._s(t.message)+"\n")])},staticRenderFns:[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("button",{staticClass:"close",attrs:{type:"button","data-dismiss":"alert","aria-label":"Close"}},[a("span",{attrs:{"aria-hidden":"true"}},[t._v("×")])])}]}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"contacts container"},[t.alert?a("Alert",{attrs:{message:t.alert}}):t._e(),t._v(" "),a("h1",{staticClass:"page-header"},[t._v("Manage Contacts")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.filterInput,expression:"filterInput"}],staticClass:"form-control",attrs:{placeholder:"Enter First Name or Last Name"},domProps:{value:t.filterInput},on:{input:function(e){e.target.composing||(t.filterInput=e.target.value)}}}),t._v(" "),a("br"),t._v(" "),a("table",{staticClass:"table table-striped"},[t._m(0),t._v(" "),a("tbody",t._l(t.filterBy(t.contacts,t.filterInput),function(e){return a("tr",[a("td",[t._v(t._s(e.firstName))]),t._v(" "),a("td",[t._v(t._s(e.lastName))]),t._v(" "),a("td",[t._v(t._s(e.phoneNumber))]),t._v(" "),a("td",[a("router-link",{staticClass:"btn btn-default",attrs:{to:"/contact/"+e.id}},[t._v("View")])],1)])}),0)])],1)},staticRenderFns:[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("thead",[a("tr",[a("th",[t._v("First Name")]),t._v(" "),a("th",[t._v("Last Name")]),t._v(" "),a("th",[t._v("Phone Number")]),t._v(" "),a("th")])])}]}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[t._v("\n TEST\n")])},staticRenderFns:[]}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"edit container"},[t.alert?a("Alert",{attrs:{message:t.alert}}):t._e(),t._v(" "),a("h1",{staticClass:"page-header"},[t._v("Edit Contact")]),t._v(" "),a("form",{on:{submit:t.updateContact}},[a("div",{staticClass:"well"},[a("div",{staticClass:"form-group"},[a("label",[t._v("First Name")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.firstName,expression:"contact.firstName"}],staticClass:"form-control",attrs:{type:"text",placeholder:"First Name"},domProps:{value:t.contact.firstName},on:{input:function(e){e.target.composing||t.$set(t.contact,"firstName",e.target.value)}}})]),t._v(" "),a("div",{staticClass:"form-group"},[a("label",[t._v("Last Name")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.lastName,expression:"contact.lastName"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Last Name"},domProps:{value:t.contact.lastName},on:{input:function(e){e.target.composing||t.$set(t.contact,"lastName",e.target.value)}}})]),t._v(" "),a("div",{staticClass:"form-group"},[a("label",[t._v("Phone")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.phoneNumber,expression:"contact.phoneNumber"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Phone"},domProps:{value:t.contact.phoneNumber},on:{input:function(e){e.target.composing||t.$set(t.contact,"phoneNumber",e.target.value)}}})]),t._v(" "),a("div",{staticClass:"form-group"},[a("label",[t._v("Address")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.address,expression:"contact.address"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Address"},domProps:{value:t.contact.address},on:{input:function(e){e.target.composing||t.$set(t.contact,"address",e.target.value)}}})])]),t._v(" "),a("button",{staticClass:"btn btn-primary",attrs:{type:"submit"}},[t._v("Submit")])])],1)},staticRenderFns:[]}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"add container"},[t.alert?a("Alert",{attrs:{message:t.alert}}):t._e(),t._v(" "),a("h1",{staticClass:"page-header"},[t._v("Add Contact")]),t._v(" "),a("form",{on:{submit:t.addContact}},[a("div",{staticClass:"well"},[a("div",{staticClass:"form-group"},[a("label",[t._v("First Name")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.firstName,expression:"contact.firstName"}],staticClass:"form-control",attrs:{type:"text",placeholder:"First Name"},domProps:{value:t.contact.firstName},on:{input:function(e){e.target.composing||t.$set(t.contact,"firstName",e.target.value)}}})]),t._v(" "),a("div",{staticClass:"form-group"},[a("label",[t._v("Last Name")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.lastName,expression:"contact.lastName"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Last Name"},domProps:{value:t.contact.lastName},on:{input:function(e){e.target.composing||t.$set(t.contact,"lastName",e.target.value)}}})]),t._v(" "),a("div",{staticClass:"form-group"},[a("label",[t._v("Phone")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.phoneNumber,expression:"contact.phoneNumber"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Phone"},domProps:{value:t.contact.phoneNumber},on:{input:function(e){e.target.composing||t.$set(t.contact,"phoneNumber",e.target.value)}}})]),t._v(" "),a("div",{staticClass:"form-group"},[a("label",[t._v("Address")]),t._v(" "),a("input",{directives:[{name:"model",rawName:"v-model",value:t.contact.address,expression:"contact.address"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Address"},domProps:{value:t.contact.address},on:{input:function(e){e.target.composing||t.$set(t.contact,"address",e.target.value)}}})])]),t._v(" "),a("button",{staticClass:"btn btn-primary",attrs:{type:"submit"}},[t._v("Submit")]),t._v(" "),a("br"),t._v(" "),a("br"),t._v(" "),a("br")])],1)},staticRenderFns:[]}},,,,,function(t,e){}]);
//# sourceMappingURL=app.aa34e6f865a0e4991c22.js.map