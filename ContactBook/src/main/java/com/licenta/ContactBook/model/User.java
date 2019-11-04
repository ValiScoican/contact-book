package com.licenta.ContactBook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
// @Entity Annotation is used to declared the object as an entity.
@Table(name = "users")
//The @Table annotation allows you to specify the details of the table that will be used to persist the entity in the database.
//Auto generate getter, setter
@Data
@NoArgsConstructor
public class User {

    //Will only declare the primary key
    //@Id Annotation is for denoting the Long id value as an identifier of the table.
    // @GeneratedValue is for declaring the id values is a generated value and the user
    // do not have to provide the value of id while inserting into the database.
    // Strategy is property declared as AUTO.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;

    private int active;

    private String roles = "";

    private String permissions = "";

    public User(String username, String password, String email, String roles, String permissions){
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

    public long getUserId() {
        return id;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}

