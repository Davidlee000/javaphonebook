package controllers;

import java.awt.event.*;
import models.*;
import views.*;

public class RegisterController {
	@SuppressWarnings("unused")
	private RegisterView registerView;

    public RegisterController(RegisterView registerView) {
        this.registerView = registerView;

        registerView.addLoginListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerView.setVisible(false);

                LoginView lv = new LoginView();
                @SuppressWarnings("unused")
				LoginController lc = new LoginController(lv);
                lv.setVisible(true);
     
            }
        });
        
    registerView.addRegisterListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String username = registerView.getUsername();
            String password = registerView.getPassword();
            String password2 = registerView.getPassword2();
            
            if (username.equals("") || password.equals("") || password2.equals("")) {
                registerView.showMessage("Please fill in all fields");
            } else if (!password.equals(password2)) {
                registerView.showMessage("Passwords do not match");
            } else if (password.length() < 8) {
                registerView.showMessage("Password must be at least 8 characters long");}
            else {
                // Create a new instance of UserDataAccess
                UserDataAccess userDataAccess = new UserDataAccess();
                
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                       
                if (userDataAccess.registerUser(user)) {
                    registerView.showMessage("Registration successful");
                } else {
                    registerView.showMessage("Invalid username or password");
                }
            }
        }
    });
        
    }
}
