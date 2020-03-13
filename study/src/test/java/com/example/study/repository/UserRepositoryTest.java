package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Test
    public void read() {

        // Optional 은 있을 수도 있고 없을 수도 있다.
        Optional<User> user = userRepository.findById(6L);   // 1건 처리  // id가 Long 타입이라 6L 이라고 해야함.

        // 있다면
        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });
    }

    // 매개변수를 받아서 처리 할 수도 있다.
//    @Test
//    public User read1(@RequestParam Long id) {

//        // Optional 은 있을 수도 있고 없을 수도 있다.
//        Optional<User> user = userRepository.findById(id);   // 1건 처리  // id가 Long 타입이라 6L 이라고 해야함.
//
//        // 있다면
//        user.ifPresent(selectUser -> {
//            System.out.println("user : " + selectUser);
//            System.out.println("email : " + selectUser.getEmail());
//        });
//        return user.get();
//    }

    @Test
    public void update(){

        // Optional 은 있을 수도 있고 없을 수도 있다.
        Optional<User> user = userRepository.findById(6L);   // 1건 처리  // id가 Long 타입이라 6L 이라고 해야함.

        // 있다면
        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);    // JPA 가 selectUser 인지 user 인지가 중요한게 아니라 id 값을 찾아서 알아서 바꾼다.
        });
    }

    @Test
    @Transactional  // 데이터 삭제 후 롤백 해준다. // 즉 테스트용으로 확인만 할때  // @Transactional 주석처리하면 테스트 코드가 실행되면서 데이터 삭제됨.
    public void delete(){

        // Optional 은 있을 수도 있고 없을 수도 있다.
        Optional<User> user = userRepository.findById(1L);   // 1건 처리  // id가 Long 타입이라 6L 이라고 해야함.

        // 있다면 삭제
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);

        });

        // 삭제 됐는지 확인하기 위해 select 해보기
        Optional<User> deleteUser = userRepository.findById(1L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser.get());
        } else {
            System.out.println("데이터 삭제 데이터 없음");
        }
    }

//    @Test
//    public void deleteOther(){
//
//        // Optional 은 있을 수도 있고 없을 수도 있다.
//        Optional<User> user = userRepository.findById(7L);   // 1건 처리  // id가 Long 타입이라 7L 이라고 해야함.
//
//        Assert.assertTrue(user.isPresent());    // true // 7L 이 있다면
//
//        // 있다면 삭제
//        user.ifPresent(selectUser -> {
//            userRepository.delete(selectUser);
//
//        });
//
//        // 삭제 됐는지 확인하기 위해 select 해보기
//        Optional<User> deleteUser = userRepository.findById(7L);
//
//        Assert.assertFalse(deleteUser.isPresent()); // false
//    }
}
