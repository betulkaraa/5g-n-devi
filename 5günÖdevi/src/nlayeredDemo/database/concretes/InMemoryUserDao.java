package nlayeredDemo.database.concretes;

import java.util.ArrayList;
import java.util.List;

import nlayeredDemo.database.abstracts.UserDoa;
import nlayeredDemo.entity.concretes.User;

public class InMemoryUserDao implements UserDoa {
	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
	}

	

	
	@Override
	public User get(int id) {
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User getByEmail(String email) {
		for(User user : users) {
			if(user.getEmail() == email)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for(User user : users) {
			if(user.getEmail() == email && user.getPassword() == password)
				return user;
		}
		return null;
	}

}