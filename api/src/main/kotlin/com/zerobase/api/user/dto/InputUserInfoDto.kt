package com.zerobase.api.user.dto

import com.zerobase.domain.entity.UserInfo

class UserInfoInputDto {
    data class CreateRequest(
        val userName: String,
        val userIncomeAmount: Long,
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
        val userKey: String
    )
}