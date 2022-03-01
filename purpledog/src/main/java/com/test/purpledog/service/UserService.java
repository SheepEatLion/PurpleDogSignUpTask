package com.test.purpledog.service;

import com.test.purpledog.domain.User;
import com.test.purpledog.domain.UserRepository;
import com.test.purpledog.dto.SignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public String signUp(SignUpReq signUpReq){
        log.info(signUpReq.getId());    // 사용자가 입력한 아이디 log

        String resultMsg;
        try {
            if(signUpReq.getId().isEmpty() || signUpReq.getPassword().isEmpty()){
                throw new ServiceException("column of user entity can not be null.");
            }
            User user = User.builder()
                    .id(signUpReq.getId())
                    .password(signUpReq.getPassword())
                    .build();

            userRepository.save(user);
            resultMsg = user.getId();

        }catch (Exception e){
            resultMsg = e.getMessage(); // 클라이언트에 오류 정보 전달
            log.error(e.getMessage());  // 서버에 오류 로그 찍기
            e.printStackTrace();
        }

        return resultMsg;
    }
}
