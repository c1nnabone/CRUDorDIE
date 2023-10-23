package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeById(Long id);
    List<User> getUsers();
    User getUserById(Long id);
}
