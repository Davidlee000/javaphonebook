package views;

import models.*;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;




public class DeleteContactView extends JFrame {
    User user = new User();
    JButton backButton,deleteButton;
    JTextField firstNameTextArea, lastNameTextArea;
    JLabel jLabel1, jLabel2, jLabel3;

    public DeleteContactView(User user) {
        this.user = user;
        initComponents();
    }
    private void initComponents() {

        firstNameTextArea = new JTextField();
        lastNameTextArea = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        deleteButton = new JButton();
        backButton= new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Delete Contact");

        jLabel2.setText("First Name: ");

        jLabel3.setText("Last Name:");

        deleteButton.setText("Delete");

        backButton.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameTextArea)
                            .addComponent(lastNameTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstNameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lastNameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(backButton))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }


    public void BackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
        

    public void DeleteListner(ActionListener listener){
        deleteButton.addActionListener(listener);
    }

    public User getUser(){
        return user;
    }

    public String getFirstName(){
        System.out.println("firstname"+ firstNameTextArea.getText());
        return firstNameTextArea.getText();
    }
    public String getLastName(){
        return lastNameTextArea.getText();
    }
    

}



    
