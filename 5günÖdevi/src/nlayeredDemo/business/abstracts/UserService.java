package nlayeredDemo.business.abstracts;

import java.util.List;

import nlayeredDemo.entity.concretes.User;

public interface UserService {
	 void add(User user);
	   void verifyUser(int id);
	   User get(int id);
	   User getByEmail(String email);
	   User getByEmailAndPassword(String email,String password);
	   List<User> getAll();
}
