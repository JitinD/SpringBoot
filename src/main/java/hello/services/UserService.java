package hello.services;

import hello.config.PersistenceContext;
import hello.domains.User;
import hello.repositories.UserRepository;
import hello.util.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
    UserRepository userRepository = applicationContext.getBean(UserRepository.class);

    public List<User> findAllUsers() {
        return Util.toList(userRepository.findAll());
    }

    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.delete(id);
    }

    public boolean isUserAvailable(User user) {
        return userRepository.exists(user.getId());
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
