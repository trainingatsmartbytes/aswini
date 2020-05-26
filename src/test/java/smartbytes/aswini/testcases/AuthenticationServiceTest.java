package smartbytes.aswini.testcases;


import org.junit.Test;

import junit.framework.TestCase;
import smartbytes.aswini.AuthenticationService;

public class AuthenticationServiceTest extends TestCase {
    AuthenticationService authService = new AuthenticationService();

	@Test
	public void test_login_with_valid_credentials() {
		assertEquals(true, authService.login("aswini", "secret"));
	}
	@Test
	public void test_login_with_invalid_credentials() {
		assertEquals(false, authService.login("aswini", "secret1"));
	}

}
