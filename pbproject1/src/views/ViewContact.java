
package views;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import models.*;

public class ViewContact extends javax.swing.JFrame {
    
    User user = new User();
    public ViewContact(User user) {
        this.user = user;
        initComponents();
    }
                          
    private void initComponents() {
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phonebook");

        ContactDataAccess cda = new ContactDataAccess();
        int id = user.getId();
        
        List<Contact> contacts = new ArrayList<>(); // Declare the 'contacts' variable

        contacts = cda.getContact(id);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Contact contact : contacts) {
            String fullName = contact.getFirstname() + " " + contact.getLastname();
            listModel.addElement(fullName);
        }
        jList2.setModel(listModel);
        jScrollPane2.setViewportView(jList2);

        jLabel8.setText("Search Contacts");

        jLabel9.setText("First Name");

        jLabel10.setText("Last Name");

        jButton7.setText("Search");

        jButton8.setText("Back ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7))
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    
    // Variables declaration                     
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private JTextField jTextField6;
    private JTextField jTextField7;

    public String getFirstName(){
        return jTextField6.getText();
    }

    public String getLastName(){
        return jTextField7.getText();
    }
     public void SearchListener(ActionListener listener){
        jButton7.addActionListener(e -> {
            if(validateInput()){
                listener.actionPerformed(e);
            }
        });
    }

    public void addBackListener(ActionListener listener){
        jButton8.addActionListener(listener);
    }

    private boolean validateInput(){
        String firstName = getFirstName();
        String lastName = getLastName();

        // Perform validation checks
        if(firstName.isEmpty() || lastName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter First Name and Last Name", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    public User getUser(){
        return user;
    }
}
