package models;

// This class is a model class that represents a contact
public class Contact {
    private String firstname;
    private String lastname;
    private String email ;
    private String phone;
    private String address;
    private int id;
    
    // Constructor
    public Contact() {
        super();
    }
    public Contact(String firstname, String lastname, String email, String phone, String address, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }
        
    // Getters
    public String getFirstname() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAddress() {
        return address;
    }
    public int getId() {
        return id;
    }
    // Setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setId(int id) {
        this.id = id;
    }


}
