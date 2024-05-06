package views;

import java.awt.event.ActionListener;

import javax.swing.*;


//LoginView class
public class LoginView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton loginButton, registerButton;
    private JLabel label;
    private JTextArea username;
    private JPasswordField password;
    
    //constructor
    public LoginView() {

       
        setTitle("Phonebook App");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        label = new JLabel("Login");
        label.setBounds(360, 20, 200, 60);
        add(label);

        label = new JLabel("Username:");
        label.setBounds(40, 100, 160, 60);
        add(label);

        label = new JLabel("Password:");
        label.setBounds(40, 200, 160, 60);
        add(label);

        username = new JTextArea();
        username.setBounds(200, 100, 400, 60);
        add(username);
        

        password = new JPasswordField();
        password.setBounds(200, 200, 400, 60);
        add(password);
        

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 300, 180, 60);
        add(loginButton);

        registerButton = new JButton("New Here?  Register");
        registerButton.setBounds(420, 300, 180, 60);
        add(registerButton);

        setVisible(false);
    }

    //login listener
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

    

}