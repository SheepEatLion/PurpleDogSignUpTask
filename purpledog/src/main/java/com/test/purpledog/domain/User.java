package com.test.purpledog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;


    /**
     * 유저 도메인 저장 메서드
     * @param id
     * @param password
     */

    @Builder
    public User(String id, String password){
        this.id = id;
        this.password = password;
    }

}
