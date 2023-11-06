package com.zerobase.api.user.dto

import com.zerobase.domain.entity.UserInfo

class UserInfoReadDto {
    data class ReadResponse(
        val userKey: String,
        val userRegistrationNumber: String
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