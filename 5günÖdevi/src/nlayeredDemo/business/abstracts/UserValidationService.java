package nlayeredDemo.business.abstracts;

import nlayeredDemo.entity.concretes.User;

public interface UserValidationService {
    boolean validate(User user);

}
