package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.*;
import views.ContactView;
import views.ViewContact;

public class ViewContactController {
    User user = new User();
    public ViewContactController(ViewContact vc){

        

        vc.SearchListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Contact contact;
                String firstName = vc.getFirstName();
                String lastName = vc.getLastName();
                user =vc.getUser();
                int id = user.getId();

                ContactDataAccess cda = new ContactDataAccess();
                contact = cda.searchContact(firstName, lastName, id);

                // If the contact is not found, display an error message
                if (contact == null) {
                    JOptionPane.showMessageDialog(null, "Contact not found");
                    return;
                }

                // Create a pop-up window to display the contact information
                JOptionPane.showMessageDialog(null, "Contact Information:\n" +
                    "First Name: " + contact.getFirstname() + "\n" +
                    "Last Name: " + contact.getLastname() + "\n" +
                    "Phone Number: " + contact.getPhone() + "\n" +
                    "Email: " + contact.getEmail()+"\n"+
                    "Address: "+ contact.getAddress());
            }
        });

        vc.addBackListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                user = vc.getUser();
                vc.setVisible(false);
                ContactView cv = new ContactView(user);
                cv.setVisible(true);
                ContactController cc = new ContactController(cv);
            }
        });
    }

    
    
}
