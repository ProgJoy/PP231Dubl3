package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    List<User> listUsers();
    void editSalary(Long id, int salary);
    void dropUser(Long id);
    User getUserById(Long id);
}
