package Login;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import View.AdminView;

public class AdminLogin implements LoginGenerator{

	public void Login() throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		AdminView r= new AdminView();
        r.frame.setVisible(true);
	}

}
