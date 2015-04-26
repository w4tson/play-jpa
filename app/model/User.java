package model; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                       generator = "seq")
    @SequenceGenerator(name = "seq",
                      sequenceName = "user_seq")
     private int id;
     
 String Name = null;
 String Login = null;
 String Password = null;

public int getId(){
     return id;
}
public void setId(int id){
this.id = id;
}
public String getName(){
return Name;
}
public void setName(String Name){
this.Name = Name;
}
public String getLogin(){     
return Login;
}
public void setLogin(String Login){
     this.Login = Login;
}
public String getPassword(){
     return Password;
}
public void setPassword(String Password){
     this.Password = Password;
}
     
}