package nlayeredDemo.business.concretes;

import nlayeredDemo.business.abstracts.EmailService;

public class EmailMan implements EmailService{

	@Override
	public void send(String message, String to) {
		System.out.println("E-posta : " + message );
	}
}
