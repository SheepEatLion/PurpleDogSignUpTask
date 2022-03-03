
**퍼플독 과제 테스트**
- 웹 서버 구현
- 회원 가입 기능
- 회원 탈퇴(삭제) 기능
- 비밀번호 변경 기능

- - -

**상세 조건**
- 회원 테이블 생성
- Entity 는 id 와 password 컬럼만 가진다.
- Spring boot 활용
- Java JDK 8 이상
- Password 보안은 예외
- 프론트엔드 필요 없음. 포스트맨 사용
- JSON return
- JPA 를 사용하지 않아도 무방
- 회원 테이블 Create Query 를 제공
 
- - -
 
**회원 테이블 Create Query**

create table user (<br>
    id varchar(255) not null, <br>
    password varchar(255) not null, <br>
    primary key (id) <br>
)

***h2 db 를 사용하고 auto create 가 적용되어 있어, create query 를 칠 필요는 없습니다.***
