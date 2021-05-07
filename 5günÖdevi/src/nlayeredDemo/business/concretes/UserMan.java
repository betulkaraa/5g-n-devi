package nlayeredDemo.business.concretes;

import java.util.List;

import nlayeredDemo.business.abstracts.UserService;
import nlayeredDemo.database.abstracts.UserDoa;
import nlayeredDemo.entity.concretes.User;

public class UserMan implements UserService{

	private UserDoa userDao;
 

	public UserMan(UserDoa userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public void add(User user) {
		userDao.add(user);
	}



	@Override
	public User get(int id) {
		return userDao.get(id);
	}


	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}


	@Override
	public User getByEmailAndPassword(String email, String password) {
		return userDao.getByEmailAndPassword(email, password);
	}


	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}


	@Override
	public void verifyUser(int id) {
		User user = userDao.get(id);
		user.setVerified(true);
		System.out.println(" doðrulandý..");
	}

}
