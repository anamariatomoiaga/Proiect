package Login;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


import View.ShopView;



public class UserLogin implements LoginGenerator{

	public void Login() throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		ShopView r= new ShopView();
        r.frame.setVisible(true);
	}

}
