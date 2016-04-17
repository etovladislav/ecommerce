package ru.kpfu.shop.util;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.shop.model.User;


public class SecurityUtils {


    /**
     * Метод для удобства, чтобы каждый раз не писать огромную запись
     * @return
     */
    public static User getCurrentUser() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
