package com.test.purpledog.service;

import com.test.purpledog.domain.User;
import com.test.purpledog.domain.UserRepository;
import com.test.purpledog.dto.SignUpReq;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void signUp() {
        // given
        SignUpReq user = new SignUpReq("id1234", "pass1234");

        // when
        String userId = userService.signUp(user);
        Optional<User> signInUser = userRepository.findById(userId);

        // then
        assertEquals(user.getId(), signInUser.orElseThrow().getId());
    }

}