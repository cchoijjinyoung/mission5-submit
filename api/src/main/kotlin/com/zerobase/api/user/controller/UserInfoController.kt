package com.zerobase.api.user.controller

import com.zerobase.api.common.CustomResponse
import com.zerobase.api.common.CustomResponseCode
import com.zerobase.api.user.dto.InputUserInfoDto
import com.zerobase.api.user.service.UserInfoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/v1/user")
@Api(description = "유저 정보 API")
class UserInfoController(
    private val userInfoService: UserInfoService
) {

    @ApiOperation(value = "유저 정보 수신 API", notes = "유저 정보를 받는 API")
    @PostMapping("/information")
    fun saveUserInfo(
        @RequestBody createRequest: InputUserInfoDto.CreateRequest
    ): CustomResponse.ResponseDto {
        val data = userInfoService.userInfoMain(createRequest)
        return CustomResponse(data, CustomResponseCode.SUCCESS).toResponseDto()
    }

    @ApiOperation(value = "유저 정보 조회 API", notes = "유저 정보를 조회하는 API")
    @GetMapping("/private-info/{userKey}")
    fun getUserInfo(@PathVariable userKey: String
    ): CustomResponse.ResponseDto {
        val data = userInfoService.getUserInfoDto(userKey)
        return CustomResponse(data, CustomResponseCode.SUCCESS).toResponseDto()
    }
}