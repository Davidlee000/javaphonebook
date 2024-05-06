package views;

import models.*;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


 public class AddContactView extends javax.swing.JFrame {
    User user = new User();

     public AddContactView(User user) {
        this.user = user;
         initComponents();
     }
                            
     private void initComponents() {
 
         buttonGroup1 = new javax.swing.ButtonGroup();
         jPanel1 = new javax.swing.JPanel();
         jLabel1 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         jTextField1 = new javax.swing.JTextField();
         jTextField2 = new javax.swing.JTextField();
         jLabel3 = new javax.swing.JLabel();
         jTextField3 = new javax.swing.JTextField();
         jLabel4 = new javax.swing.JLabel();
         jTextField4 = new javax.swing.JTextField();
         jButton7 = new javax.swing.JButton();
         jLabel5 = new javax.swing.JLabel();
         jTextField5 = new javax.swing.JTextField();
         jButton2 = new javax.swing.JButton();
         jLabel6 = new javax.swing.JLabel();
         jButton1 = new javax.swing.JButton();
 
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
         setTitle("Phonebook");
 
         jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Contact"));
 
         jLabel1.setText("First Name:");
 
         jLabel2.setText("Last Name:");
 
         jLabel3.setText("Phone Number:");

         jLabel4.setText("Email:");

         jButton7.setText("Add");

         jLabel5.setText("Address:");

         jButton2.setText("Back");

         jButton1.setText("Update");

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(28, 28, 28)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                             .addComponent(jLabel3)
                             .addComponent(jLabel1)
                             .addComponent(jLabel5))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(jPanel1Layout.createSequentialGroup()
                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                     .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                     .addComponent(jLabel2)
                                     .addComponent(jLabel4))
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                     .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                             .addComponent(jTextField5)))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jButton1)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jButton7)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jButton2)))
                 .addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel2))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel3)
                     .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel4)
                     .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel5)
                     .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jButton7)
                     .addComponent(jButton2)
                     .addComponent(jButton1)))
         );
 
         jLabel6.setText("");
 
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jLabel6)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGap(14, 14, 14)
                 .addComponent(jLabel6)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(46, Short.MAX_VALUE))
         );
 
         pack();


     }                      
 
                                  
     
     
     // Variables declaration                    
     private javax.swing.ButtonGroup buttonGroup1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton7;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JTextField jTextField1;
     private javax.swing.JTextField jTextField2;
     private javax.swing.JTextField jTextField3;
     private javax.swing.JTextField jTextField4;
     private javax.swing.JTextField jTextField5;
     // End of variables declaration
     
     public String getFirstName(){
        return jTextField1.getText();
     }
     public String getLastName(){
        return jTextField2.getText();
     }

    public String getPhoneNumber(){
        return jTextField3.getText();
    }

    public String getEmail(){
        return jTextField4.getText();
    }

    public String getAddress(){
        return jTextField5.getText();
    }

    public void addAddListener(ActionListener listener){
        jButton7.addActionListener(e -> {
            if(validateInput()){
                listener.actionPerformed(e);
            }
        });
    }
    public void addUpdateListener(ActionListener listener){
        jButton1.addActionListener(e -> {
            if(validateInput()){
                listener.actionPerformed(e);
            }
        });
    }

    public void addBackListener(ActionListener listener){
        jButton2.addActionListener(listener);
    }

    private boolean validateInput(){
        String firstName = getFirstName();
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();

        // Perform validation checks
        if(firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter First Name Last Name and phone Number", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //validate phone number
        if(phoneNumber.length() != 10){
            JOptionPane.showMessageDialog(this, "Phone number must be 10 digits", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //validate email
        if(!getEmail().isEmpty()){
            String email = getEmail();
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if(!email.matches(emailRegex)){
                JOptionPane.showMessageDialog(this, "Invalid email address", "Input Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
    public User getUser(){
        return user;
    }

    
     
 }

