package controllers;
import models.*;
import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.List;
import java.io.PrintWriter;


public class ContactController {
    private ContactView contactView;
    User user = new User();
    public ContactController(ContactView cv) {
        this.contactView = cv;
        user = contactView.getUser();
        
        
        // Add action listener for the register button
        contactView.addContact(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            contactView.setVisible(false);
            

            AddContactView acv = new AddContactView(user);
            acv.setVisible(true);
            AddContactController acc = new AddContactController(acv);
            }
        });

        contactView.viewContacts(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                contactView.setVisible(false);
                
                ViewContact vc = new ViewContact(user);
                ViewContactController vcc = new ViewContactController(vc);
                vc.setVisible(true);

            }
        });
        contactView.exportContact(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ContactDataAccess contactDataAccess = new ContactDataAccess();
                int id = user.getId();
                List<Contact> contacts = contactDataAccess.getContact(id);
                try {
                    PrintWriter writer = new PrintWriter("contacts.csv");
                    writer.println("First Name, Last Name, Phone Number, Address, Email");
                    for (Contact contact : contacts) {
                        writer.println(contact.getFirstname() + "," + contact.getLastname() + ", " + contact.getPhone() + ","+ contact.getAddress() + ","+ contact.getEmail());
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Contacts exported successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error exporting contacts: " + ex.getMessage());
                }

            }
        });

        contactView.deleteContact(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                contactView.setVisible(false);
                DeleteContactView dc = new DeleteContactView(user);
                dc.setVisible(true);
                DeleteContactController dcc = new DeleteContactController(dc);

            }
        });

        contactView.EmailContact(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                contactView.setVisible(false);
                EmailContactView ecv = new EmailContactView(user);
                ecv.setVisible(true);
                EmailContactController ecc = new EmailContactController(ecv);

            }
        });

    }
    

}
