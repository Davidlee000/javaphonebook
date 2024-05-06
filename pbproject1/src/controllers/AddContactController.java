package controllers;

import views.*;
import models.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AddContactController {
    User user = new User();
    public AddContactController(AddContactView addContactView) { 

    

        addContactView.addAddListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fname = addContactView.getFirstName();
                String lname = addContactView.getLastName();
                String phone = addContactView.getPhoneNumber();
                String email = addContactView.getEmail();
                String address = addContactView.getAddress();

                user = addContactView.getUser();
                int id = user.getId();

                Contact contact = new Contact(fname, lname, phone, email, address, id);
                ContactDataAccess contactData = new ContactDataAccess();
                if (contactData.addContact(contact)) {
                    JOptionPane.showMessageDialog(null, "Contact added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Could not add contact", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        addContactView.addUpdateListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user = addContactView.getUser();
                String fname = addContactView.getFirstName();
                String lname = addContactView.getLastName();
                String phone = addContactView.getPhoneNumber();
                String email = addContactView.getEmail();
                String address = addContactView.getAddress();
                int id = user.getId();
                Contact contact = new Contact(fname, lname, phone, email, address, id);
                ContactDataAccess contactData = new ContactDataAccess();
                if (contactData.updateContact(contact)) {
                    JOptionPane.showMessageDialog(null, "Contact updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Could not update contact", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addContactView.addBackListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                user = addContactView.getUser();
                addContactView.setVisible(false);
                ContactView cv = new ContactView(user);
                cv.setVisible(true);
                ContactController cc = new ContactController(cv);
            }
        });
    }
}
