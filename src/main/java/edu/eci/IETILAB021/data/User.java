package edu.eci.IETILAB021.data;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@Document
public class User
{
    @Id
    public
    String id;

    String name;

    @Indexed( unique = true )
    String email;

    String lastName;

    public LocalDate createdAt;

    public User()
    {
    }
    public String getEmail (){
        return email;
        
    }
    public String getName (){
        return name;
        
    }
    public String getLastName (){
        return lastName;
        
    }
    public String getId (){
        return id;
        
    }
    public LocalDate getCreateAt (){
        return createdAt;
        
    }
    public void setId (String id){
        this.id = id;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setEmail (String email){
        this.email = email;
    }
    public void setLastname (String lastname){
        this.lastName = lastname;
    }

    public void setdate(LocalDate localDate) {
        this.createdAt = localDate;
    }
    public void setCreatedAt(LocalDate createdAt2) {
    }
}
