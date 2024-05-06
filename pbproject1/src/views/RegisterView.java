package views;


import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterView extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 63682802992801601L;
	private JButton loginButton, registerButton;
    private JTextArea username;
    private JLabel label;
    private JPasswordField password;
    private JPasswordField password2;

    public RegisterView(){
        setTitle("Phonebook App");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        label = new JLabel("Register");
        label.setBounds(360, 20, 200, 60);
        add(label);

        label = new JLabel("Username:");
        label.setBounds(40, 100, 160, 60);
        add(label);

        label = new JLabel("Password:");
        label.setBounds(40, 200, 160, 60);
        add(label);
        
        label = new JLabel("Confirm Password:");
        label.setBounds(40, 300, 160, 60);
        add(label);

        username = new JTextArea();
        username.setBounds(200, 100, 400, 60);
        add(username);

        password = new JPasswordField();
        password.setBounds(200, 200, 400, 60);
        add(password);

        password2 = new JPasswordField();
        password2.setBounds(200, 300, 400, 60);
        add(password2);
        

        loginButton = new JButton("Back to Login");
        loginButton.setBounds(200, 400, 180, 60);
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(420, 400, 180, 60);
    
        add(registerButton);

        setVisible(false);
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
    
    public void addRegisterListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }

    public String getUsername() {
        return username.getText();
    }
    public String getPassword() {
        return new String(password.getPassword());
    }
    public String getPassword2() {
        return new String(password2.getPassword());
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
