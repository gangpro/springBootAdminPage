package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    // Dependency Injection (DI) , 의존성 주입
    // 그래서 UserRepository userRepository = new UserRepository(); 안해도 됨.
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s, %d) value(account, email, age); 쿼리문을 갖고 값을 매칭 후 실행 했었는데
        // JPA 를 가지고 Object 를 다루기 때문에 아래와 같이 쓴다.
        User user = new User();
//        user.setId();   // DB 에 자동으로 넣어주기로 했으니 주석처리
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@email.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    public void read() {

    }

    public void update(){

    }

    public void delete(){

    }
}
