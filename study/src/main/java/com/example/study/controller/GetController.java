package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")    // localhost:8080/api/getMethod
    public String getRequest() {

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")    // localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id,
                               @RequestParam(name = "password") String pwd) {
        // 스프링 부트에서는 @RequestParam 받는 값을 지역 변수를 받는건 좋은 방법이 아니다.
        // 하지만 받아야 한다면 @RequestParam(name = "password") String pwd 이렇게 하고 String password = "bbbb";
        String password = "bbbb";

        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);

        return id + pwd;
    }

    // localhost:8080/api/getMultiParameter?account=abcd&email=study@email.com&page=10
    @GetMapping("/getMultiParameter1")
    public String getMultiParameter1(@RequestParam String account,
                                    @RequestParam String email,
                                    @RequestParam int page){
        return "";
    }

    // 이 방법은 받는 파라미터각 많으면 @RequestParam 을 계속 적어줘야하는 단점이 있으므로
    // model - SearchParam 클래스를 만든 후 객체로 받는게 좋다.

    // @RequestParam 이 많아지면 아래와 같이 SearchParam 으로 객체로 받으면 좋다.
    @GetMapping("/getMultiParameter2")
    public String getMultiParameter2(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }

    // { "account" : "", "email" : "", "page" : 0}
    // JSON 으로 받는 방법
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }

}
