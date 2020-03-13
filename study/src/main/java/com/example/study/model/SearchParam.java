package com.example.study.model;

public class SearchParam {

    private String account;
    private String email;
    private int page;

    // 객체 파라미터를 받기 위해서는 getter&setter 생성자가 있어야 한다.
    // getter & setter
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
