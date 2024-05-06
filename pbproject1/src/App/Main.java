package App;

import views.*;
import controllers.*;
public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        @SuppressWarnings("unused")
		LoginController logincontroller = new LoginController(loginView);
        loginView.setVisible(true);
        
    }
}
