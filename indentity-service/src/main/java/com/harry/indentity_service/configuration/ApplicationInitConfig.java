package com.harry.indentity_service.configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.harry.indentity_service.entity.User;
import com.harry.indentity_service.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    //    PasswordEncoder passwordEncoder;
    //
    //    @Bean
    //    @ConditionalOnProperty(
    //            prefix = "spring",
    //            value = "datasource.driverClassName",
    //            havingValue = "com.mysql.cj.jdbc.Driver")
    //    ApplicationRunner applicationRunner(UserRepository userRepository) {
    //        log.info("Init application...");
    //        return args -> {
    //            if (userRepository.findByUsername("admin").isEmpty()) {
    //                var roles = new HashSet<String>();
    //                roles.add(Role.ADMIN.name());
    //                User user = User.builder()
    //                        .username("admin")
    //                        .password(passwordEncoder.encode("admin"))
    //                        //.roles(roles)
    //                        .build();
    //                userRepository.save(user);
    //                log.warn("admin user has been created with default pasword admin, please change it");
    //            }
    //        };
    //    }
    PasswordEncoder passwordEncoder;

    @Bean
    @ConditionalOnProperty(
            prefix = "spring",
            value = "datasource.driverClassName",
            havingValue = "com.mysql.cj.jdbc.Driver")
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        log.info("Init application...");
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .build();
                userRepository.save(user);
                log.warn("admin user has been created with deefault password admin, please change it");
            }
        };
    }
}
