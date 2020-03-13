package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api   // (참고) GetController 랑 똑같은 @RequestMapping("/api") 를 썼지만 method 이름이 다르면 PostController 에 써도 상관없다.
public class PostController {

    // POST 는 HTML <form> tag, ajax 검색 등에서 사용된다. 즉, 받는 파라미터가 많다는 뜻.
    // http post body -> data

    // json, xml, multipart-form, text-plain
    // 만약 기본인 json 이 아니라 다르게 받고 싶다면 이렇게 @PostMapping(value = "/postMethod", produces = {"application-xml"})


    //= 아래와 같은 의미 @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    @PostMapping("/postMethod1")
    public String postMethod1() {

        return "OK";
    }

    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {

        return searchParam;
    }

}
