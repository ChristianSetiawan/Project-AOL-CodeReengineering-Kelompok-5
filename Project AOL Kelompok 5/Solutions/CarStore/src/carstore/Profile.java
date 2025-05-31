package carstore;
/*
Authors: Salma Ashraf && Ayda Ibrahim  .
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm.
Summary of Profile: 
1-  purpose of this class is make some thing that has common attributes of many classes in our project
2- to reduce the code written 
*/


// smell code : Data class
// reason : Sudah ada constructor ada setter lagi
// solution : remove setter and use constructor only

//smell code : primitive obsession
// reason : ID is int, email is String, contactNumber is String
// solution : use wrapper class for ID, email, and contactNumber
public class Profile {
    
    
    //the atributes that any type of car shoud have it.
   protected String name ;
   protected String address ;
   protected String contactNumber ;
   protected String email ;
   protected int ID ;
   
   
   //constuctor 
   public Profile(String name,String address,String contactNumber,String email,int ID){
       this.ID=ID;
       this.address=address;
       this.email=email;
       this.name=name;
       this.contactNumber=contactNumber;
   }
   
   
/*
Seter and getter
Description: the purpose of this fuctions :- Set and get the value of the instance variable 
*/
public void setName(String name ){
this.name= name;}


public String getName(){
return name ;}


public void setAddress(String address){
this.address=address;}


public String getAddress(){
return address;}


public void setContactNumber(String contactNumber ){
    this.contactNumber=contactNumber; }


public String getContactNumber(){
return contactNumber ;}


public void setEmail(String email){
this.email=email;}


public String getEmail(){
return email ;}


public void setID(int ID){
this.ID=ID ;
}


public int getId(){
return ID ;} 



//Description: this function is type of override which used to show details of class 

@Override
public String toString (){
return name+"\t"+address+"\t     "+contactNumber+"\t   "+email+"\t    "+ID+"\t";
}

// Description:the purpose of this fuction :-  copy of the object on which it is called

@Override
public Profile clone(){
Profile c =new Profile (name,address,contactNumber,email,ID);
return c; }


// Description:the purpose of this fuction :-  compare the object on which it is called with its parmeters

@Override
public boolean equals (Object o){
     Profile p = (Profile) o;
    return ID == p.ID &&
           name.equals(p.name) && address.equals(p.address) && contactNumber.equals(p.contactNumber) && email.equals(p.email);
}

  
}



