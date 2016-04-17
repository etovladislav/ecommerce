package ru.kpfu.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.shop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Ищем юзера по логину
     * @param login
     * @return
     */
    User findOneByLogin(String login);


}
