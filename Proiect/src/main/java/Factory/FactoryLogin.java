package Factory;

import Login.AdminLogin;
import Login.LoginGenerator;
import Login.UserLogin;

public class FactoryLogin {
	String generator = "";
	public String getGenerator() {
		return generator;
	}

	public FactoryLogin(String generator) {
		this.generator = generator;
	}
	public LoginGenerator Report() {
		if (generator.equals("admin")) {
			return new AdminLogin();
		}

		return new UserLogin();

	}

}
