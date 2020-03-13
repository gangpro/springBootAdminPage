package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor // 모든 매개변수를 갖는 생성자 생성
@NoArgsConstructor  // 기본생성자 생성
@Entity //= DB 의 테이블을 의미
//@Table(name = "user")   // 스키마 테이블과 이름이 같다면 따로 명시 안해줘도 됨.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key 식별키의 전략 설정
    private Long id;
//    @Column(name = "account")   // DB 컬럼과 동일하다면 생략 가능
    private String account;
    private String email;
    private String phoneNumber; // JPA 에서 DB 의 phone_number 를 자동으로 해준다. 그래서 phone_number 해줄 필요 없음.
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
