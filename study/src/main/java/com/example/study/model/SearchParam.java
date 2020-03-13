package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   // 기본 생성자, getter&setter, toString 등 자동으로 생성
@AllArgsConstructor // 모든 매개변수를 받는 생성자 생성 // SearchParam(String, String, int)
public class SearchParam {

    private String account;
    private String email;
    private int page;

}
