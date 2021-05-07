package nlayeredDemo.database.abstracts;

import java.util.List;

import nlayeredDemo.entity.concretes.User;

public interface UserDoa {
	void add(User user);
    User get(int id);
    User getByEmail(String email);
    User getByEmailAndPassword(String email,String password);
    List<User> getAll();
}
