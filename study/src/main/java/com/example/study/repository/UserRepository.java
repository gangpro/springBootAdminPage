package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<타입1, 타입2> 타입1 : 어떠한 타입의 오브젝트 클라스인지, 타입2 : 기본키의 어떠한 타입이 있는지
}
