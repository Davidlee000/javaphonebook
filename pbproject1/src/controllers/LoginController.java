package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import models.*;
import javax.swing.JOptionPane;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView LoginView) {
        this.loginView = LoginView;

        // Add action listener for the register button
        LoginView.addRegisterListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hide the login view
                LoginView.setVisible(false);

                // Create and show the registration view
                RegisterView rv = new RegisterView();
                rv.setVisible(true);
                @SuppressWarnings("unused")
				RegisterController rc = new RegisterController(rv);
                
            }
        });
        
        LoginView.addLoginListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = loginView.getUsername();
                String password = loginView.getPassword();
                User user = new User();

                UserDataAccess userData = new UserDataAccess();

                if(userData.loginUser(username, password)!=null) {
                    user = userData.loginUser(username, password);
                    loginView.setVisible(false);
                    ContactView cv = new ContactView(user);
                    cv.setVisible(true);
                    @SuppressWarnings("unused")
					ContactController cc = new ContactController(cv);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        	
        	
        });
    }
}
