package nlayeredDemo.business.concretes;

import nlayeredDemo.business.abstracts.EmailService;
import nlayeredDemo.business.abstracts.UserService;
import nlayeredDemo.business.abstracts.UserValidationService;
import nlayeredDemo.core.AuthService;
import nlayeredDemo.core.Rules;
import nlayeredDemo.entity.concretes.User;

public class AuthManager implements AuthService{

	UserService userService;
	UserValidationService userValidationService;
	EmailService emailService;
	
	
	public AuthManager(UserService userService, UserValidationService userValidationService, EmailService emailService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
	}

	@Override
	public void register(int id, String email,String password,String firstName,String lastName) {
		User userToRegister = new User(id,email,password,firstName,lastName,false);
		
		if(!userValidationService.validate(userToRegister)) {
			System.out.println("L�tfen t�m alanlar� do�ru girdi�inizden emin olunuz.");
			return;
		}
		
		if(!Rules.run(checkIfUserExists(email))) {
			System.out.println("Bu email ile bir ba�ka �ye mevcut.");
			return;
		}
		
		System.out.println(" kay�t olundu. ");
		
	}

	@Override
	public void login(String email, String password) {
		if(!Rules.run(checkIfAllFieldsFilled(email, password))) {
			System.out.println("ba�ar�s�z. .");
			return;
		}
		
		User userToLogin = userService.getByEmailAndPassword(email, password);
		
		if(userToLogin == null) {
			System.out.println("E-posta adresiniz veya �ifreniz yanl��.");
			return;
		}
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("�yeli�inizi do�rulamad�n�z.");
			return;
		}
		System.out.println("ba�ar�l�: " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
	}
	
	
	private boolean checkIfUserExists(String email) {
		return userService.getByEmail(email) == null;
	}
	private boolean checkIfUserVerified(User user) {
		return user.isVerified();
	}
	private boolean checkIfAllFieldsFilled(String email,String password) {
		if(email.length()<=0 || password.length() <=0) {
			return false;
		}
		return true;
	}
	

	
}