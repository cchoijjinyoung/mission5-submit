package com.zerobase.api.user.service.impl

import com.zerobase.api.user.dto.InputUserInfoDto
import com.zerobase.api.user.dto.ReadUserInfoDto

interface UserInfoService {
    fun userInfoMain(createRequest: InputUserInfoDto.CreateRequest): InputUserInfoDto.CreateResponse
    fun saveUserInfo(createRequest: InputUserInfoDto.CreateRequest, userKey: String)
    fun getUserInfo(userKey: String): ReadUserInfoDto.ReadResponse
}