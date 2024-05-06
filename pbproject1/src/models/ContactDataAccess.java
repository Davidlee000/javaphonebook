package models;


import java.sql.*;
import utils.*;
import java.util.List;
import java.util.ArrayList;


// Makes connection to SQL database
public class ContactDataAccess {
    private Connection connection;

    public ContactDataAccess() {
        this.connection = Util.connection();
    }


    // Gets contacts from the database
    public List<Contact> getContact(int id) {
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM contacts WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setFirstname(resultSet.getString("firstname"));
                contact.setLastname(resultSet.getString("lastname"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhone(resultSet.getString("phone"));
                contact.setAddress(resultSet.getString("address"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }


    public Contact searchContact(String firstName, String lastName, int id) {
        String query = "SELECT * FROM contacts WHERE firstname = ? AND lastname = ? AND id = ?";
        Contact contact = null; // Initialize as null to handle no results
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                contact = new Contact();
                contact.setFirstname(resultSet.getString("firstname"));
                contact.setLastname(resultSet.getString("lastname"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhone(resultSet.getString("phone"));
                contact.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }
    
    

    //Search Conact

    // Updates a contact in the database
    public boolean updateContact(Contact contact ) {
        boolean success = false;
        String query = "UPDATE contacts SET email = ?, phone = ?, address = ? WHERE firstname = ? AND lastname = ? AND id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(4, contact.getFirstname());
            preparedStatement.setString(5, contact.getLastname());
            preparedStatement.setString(1, contact.getEmail());
            preparedStatement.setString(2, contact.getPhone());
            preparedStatement.setString(3, contact.getAddress());
            preparedStatement.setInt(6, contact.getId());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    // Adds a contact to the database
    public boolean addContact(Contact contact ) {
        boolean success = false;
        String query = "INSERT INTO contacts (id, firstname, lastname, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, contact.getId());
            preparedStatement.setString(2, contact.getFirstname());
            preparedStatement.setString(3, contact.getLastname());
            preparedStatement.setString(4, contact.getEmail());
            preparedStatement.setString(5, contact.getPhone());
            preparedStatement.setString(6, contact.getAddress());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    //delete a contact
    public boolean deleteContact(String firstName, String lastName, int id){
        boolean success = false;
        String query = "DELETE FROM contacts WHERE firstname = ? AND lastname = ? AND id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                success = true;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
