package com.msa.user.repository;

import com.msa.user.entity.User;
import com.msa.user.entity.UserRole;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest            //구동되므로 조금 무겁다.
//@DataJpaTest      //JPA 기본적으로 roll back 됨.
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Rollback(false)   //roll back을 안하겠다.
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Order(1)
    void addTest() {
        int limit = 3;
        List<User> roleList = IntStream.rangeClosed(1, limit)
                .mapToObj(n -> User.builder()
                        .email(n + "@gmail.com")
                        .name("user" + n)
                        .passwd(passwordEncoder.encode("pwd" + n))
                        .point(0)
                        .build()
                        .addRole(UserRole.ROLE_USER)
                        .addRole(UserRole.ROLE_ADMIN)
                ).toList();

        userRepository.saveAll(roleList);

        assertThat(userRepository.count()).isGreaterThan(limit - 1);
    }


    @Test
    void passwordEncodingTest(){
        //given
        String pwd="pwd00";
        System.out.println("passwordEncoder = " + passwordEncoder.encode(pwd));
        //when

        //then

    }


}