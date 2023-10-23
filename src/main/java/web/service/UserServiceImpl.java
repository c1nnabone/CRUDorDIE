package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.entity.User;
import web.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User updatedUser) {
//        userDao.updateUser(updatedUser);
        userRepository.save(updatedUser);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
            return userRepository.findById(id).orElse(new User());
    }
}
