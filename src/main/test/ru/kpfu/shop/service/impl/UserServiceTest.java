package ru.kpfu.shop.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.service.UserService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {
        @Bean
        public UserService accountService() {
            return new UserServiceImpl();
        }

        @Bean
        public UserRepository accountRepository() {
            return Mockito.mock(UserRepository.class);
        }
    }

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        User account = new User();
        account.setLogin("drakosha");

        User user = new User();
        user.setLogin("drakosha");
        user.setId(1l);
        Mockito.when(userRepository.findOneByLogin("drakosha")).thenReturn(account);
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
    }

    @Test()
    public void testCheckLogin() {
        User account = new User();
        account.setId(1l);
        account.setLogin("drakosha");
        assertTrue(userService.checkLogin(account.getLogin()));
    }

    @Test
    public void testRegistrateUser() {
        User user = new User();
        user.setLogin("drakosha");
        assertTrue(userRepository.save(user).getId() == 1l);
    }
}