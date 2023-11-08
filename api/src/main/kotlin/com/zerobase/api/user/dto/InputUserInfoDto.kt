package com.zerobase.api.user.dto

import com.zerobase.domain.entity.UserInfo
import io.swagger.annotations.ApiModelProperty

class InputUserInfoDto {
    data class CreateRequest(
        @ApiModelProperty(example = "유저이름")
        val userName: String,

        @ApiModelProperty(example = "10000")
        val userIncomeAmount: Long,

        @ApiModelProperty(example = "901231-1234567")
        var userRegistrationNumber: String
    ) {
        fun toEntity(userKey: String): UserInfo {
            return UserInfo(
                userKey = userKey,
                userName = this.userName,
                userIncomeAmount = this.userIncomeAmount,
                userRegistrationNumber = this.userRegistrationNumber)
        }
    }

    data class CreateResponse(
        @ApiModelProperty(example = "eb1d2ef91e6d43a0b918916aa78dec15")
        val userKey: String
    )
}