package com.zerobase.api.user.dto

import com.zerobase.domain.entity.UserInfo
import io.swagger.annotations.ApiModelProperty

class ReadUserInfoDto {
    data class ReadResponse(
        @ApiModelProperty(example = "eb1d2ef91e6d43a0b918916aa78dec15")
        val userKey: String,

        @ApiModelProperty(example = "901231-1234567")
        var userRegistrationNumber: String
    ) {
        companion object {
            fun fromEntity(userInfo: UserInfo): ReadResponse {
                return ReadResponse(
                    userKey = userInfo.userKey,
                    userRegistrationNumber = userInfo.userRegistrationNumber
                )
            }
        }
    }
}