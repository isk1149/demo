package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class SpringMvcController2 {
    //회원 관리를 HTTP API로 만든다 생각하고 매핑을 어떻게 하는지 알아보자.
    //실제 데이터가 넘어가는 부분은 생략하고 URL 매핑만 함.

    /*** MappingClassController ***/

    /**
     * GET /mapping/users
     */
    @GetMapping
    public String users() {

        return "get users";
    }

    /**
     * POST /mapping/users
     */
    @PostMapping
    public String addUser() {

        return "post user";
    }

    /**
     * GET /mapping/users/{userId}
     */
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId = " + userId;
    }

    /**
     * PATCH /mapping/users/{userId}
     */
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId = " + userId;
    }

    /**
     * DELETE /mapping/users/{userId}
     */
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId = " + userId;
    }
}
