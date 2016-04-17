package ru.kpfu.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.shop.form.UserForm;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.model.enums.UserRole;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    //Для шифрования пароля
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Регестрируем нового пользователя
     * @param userForm
     */
    @Override
    public void registrateUser(UserForm userForm) {
        User user = new User();
        user.setLogin(userForm.getLogin());
        user.setPassword(encoder.encode(userForm.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }

    /**
     * Проверяем занят ли логин
     * @param login
     * @return
     */
    @Override
    public boolean checkLogin(String login) {
        userRepository.findOneByLogin(login);
        return userRepository.findOneByLogin(login) != null;
    }
}


