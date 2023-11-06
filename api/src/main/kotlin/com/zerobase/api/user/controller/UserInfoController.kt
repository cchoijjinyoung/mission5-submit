package com.zerobase.api.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserInfoController {

    @PostMapping("/fintech/v1/user/information")
    fun saveUserInfo(@RequestBody userInfoInputDto: UserInfoInputDto.Request
    ): ResponseEntity<UserInfoInputDto.Response> {
        TODO("implement")
    }

    @GetMapping("/fintech/v1/user/private-info/{userKey}")
    fun getUserInfo(@PathVariable userKey: String) {
        TODO("implement")
    }
}