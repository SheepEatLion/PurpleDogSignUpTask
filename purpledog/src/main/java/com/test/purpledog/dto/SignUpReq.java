package com.test.purpledog.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpReq {
    private String id;
    private String password;
}
