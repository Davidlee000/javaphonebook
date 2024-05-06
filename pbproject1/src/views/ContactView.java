package views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import models.User;

public class ContactView extends JFrame{
    User user = new User();
	private static final long serialVersionUID = -2440121997001769982L;
    private JButton addContact, viewContacts, deleteContact, exportContact, EmailContact;

    public ContactView(User user){
        this.user = user;
        setTitle("Phonebook App");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    
        setLayout(new GridLayout(3, 1)); 
    
        JPanel titlePanel = new JPanel(new GridLayout(1, 1)); 
        JLabel titleLabel1 = new JLabel("Phonebook App");
        titlePanel.add(titleLabel1); 
    
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3)); 
        
        addContact = new JButton("Add / Update Contact");
        viewContacts = new JButton("View Contacts");
        deleteContact = new JButton("Delete Contact");
        exportContact = new JButton("Export Contact");
        EmailContact = new JButton("Email Contact");
    
        buttonPanel.add(addContact);
        buttonPanel.add(viewContacts);
        buttonPanel.add(deleteContact);
        buttonPanel.add(exportContact);
        buttonPanel.add(EmailContact);
    
        add(titlePanel); 
        add(buttonPanel);
    
        setVisible(false);
    }

    public void addContact(ActionListener listener) {
        addContact.addActionListener(listener);
    }

    public void viewContacts(ActionListener listener) {
        viewContacts.addActionListener(listener);
    }

    public void deleteContact(ActionListener listener) {
        deleteContact.addActionListener(listener);
    }


    public void exportContact(ActionListener listener) {
        exportContact.addActionListener(listener);
    }

    public void EmailContact(ActionListener listener) {
        EmailContact.addActionListener(listener);
    }
    public User getUser() {
        return user;
    }



}