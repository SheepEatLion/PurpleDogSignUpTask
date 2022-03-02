package com.test.purpledog.service;

import com.test.purpledog.domain.User;
import com.test.purpledog.domain.UserRepository;
import com.test.purpledog.dto.SignUpReq;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Test
    void findAllUser() {
        // given
        SignUpReq user1 = new SignUpReq("id1", "pw1");
        SignUpReq user2 = new SignUpReq("id10", "pw1");

        // when
        userService.signUp(user1);
        userService.signUp(user2);
        List<User> userList = userService.findUsers();

        // then
        assertEquals(userList.size(), 2);
    }

    @Test
    void findUserById() {
        // given
        SignUpReq user = new SignUpReq("id1", "pw1");

        // when
        String id = userService.signUp(user);
        User foundUser = userService.findUserById(id);

        // then
        assertEquals(foundUser.getId(), id);
    }
}