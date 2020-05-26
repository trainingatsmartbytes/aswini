package smartbytes.aswini;

public class AuthenticationService {

	public boolean login(String username,String password) {
		if(username.equals("aswini")) {
			if(password.equals("secret")) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
