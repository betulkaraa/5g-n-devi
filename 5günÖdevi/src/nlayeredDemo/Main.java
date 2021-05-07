package nlayeredDemo;

import nlayeredDemo.business.abstracts.UserService;
import nlayeredDemo.business.concretes.AuthManager;
import nlayeredDemo.business.concretes.EmailMan;
import nlayeredDemo.business.concretes.UserMan;
import nlayeredDemo.business.concretes.UserValidationMan;
import nlayeredDemo.core.AuthService;
import nlayeredDemo.core.GoogleAuthManagerAdapter;
import nlayeredDemo.database.concretes.InMemoryUserDao;

public class Main {
	public static void main(String[] args) {

	UserService userService = new UserMan(new InMemoryUserDao());
	AuthService authService = new AuthManager(userService, new UserValidationMan(), new EmailMan());
	authService.register(1, "btl@gmail.com", "123456", "betl", "Kara"); //
	authService.register(3, "btl@gmail.com", "12388886", "betl", "kara"); // hatal� �ifre
	authService.register(5, "btll@gmail.com", "123456", "betl", "kara"); // hatal� mail


	authService.login("btl@gmail.com", "123456"); //do�rulanmad�
	userService.verifyUser(1); //do�ruland�

	

	
	AuthService googleAuthService = new GoogleAuthManagerAdapter();
	googleAuthService.register(6, "klyyc7@gmail.com", "123halit1234", "Halit Enes", "Kalayc�");
	googleAuthService.login("klyyc7@gmail.com", "123halit1234");
	
	
}
}
