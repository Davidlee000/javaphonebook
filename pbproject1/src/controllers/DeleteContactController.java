package controllers;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import models.*;
import views.*;
import javax.swing.JOptionPane;

public class DeleteContactController {
    User user = new User();

    public DeleteContactController( DeleteContactView dcv){

        dcv.BackListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                user = dcv.getUser();
                dcv.setVisible(false);

                ContactView cv = new ContactView(user);
                cv.setVisible(true);
                ContactController cc = new ContactController(cv);
            }
        });

        dcv.DeleteListner(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                user = dcv.getUser();
                ContactDataAccess cda = new ContactDataAccess();
                String firstName = dcv.getFirstName();
                String lastName = dcv.getLastName();

                //validate input
                if(firstName.isEmpty() || lastName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter First Name and Last Name", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int id = user.getId();
                boolean isDeleted = cda.deleteContact(firstName,lastName,id);
                if(isDeleted){
                    JOptionPane.showMessageDialog(null, "Contact Deleted Successfully");
                }
            }
        });




    }


}
