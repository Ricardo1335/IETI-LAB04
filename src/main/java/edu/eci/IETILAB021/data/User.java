package edu.eci.IETILAB021.data;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;
import edu.eci.IETILAB021.dto.*;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Document
public class User
{
    private String passwordHash;
    private List<RoleEnum> roles;
    @Id
    public
    String id;

    String name;

    @Indexed( unique = true )
    String email;

    String lastName;

    public LocalDate createdAt;

    public User(UserDto userDto)
    {
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }
    public String getEmail (){
        return email;
        
    }
    public String getName (){
        return name;
        
    }
    public String getPasswordHash(){
        return passwordHash;
    }
    public List<RoleEnum> getRoles(){
        return roles;
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
