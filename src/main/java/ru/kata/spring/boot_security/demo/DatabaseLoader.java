package ru.kata.spring.boot_security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final UserService userService;

    public DatabaseLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {

        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        userService.createRole(adminRole);
        userService.createRole(userRole);

        User main = new User("admin", "admin", 22, "admin", "admin");
        main.addRole(adminRole);
        main.addRole(userRole);

        User ricardo = new User("user", "user", 23, "user", "user");
        ricardo.addRole(userRole);


        userService.createUser(main);
        userService.createUser(ricardo);
    }
}
