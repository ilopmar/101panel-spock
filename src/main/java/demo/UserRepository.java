package demo;

import java.util.List;

public interface UserRepository {

    User findById(Long id);
    List<User> findAllByLastName(String lastName);
}
