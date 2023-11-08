package com.zerobase.api.user.service

import com.zerobase.api.exception.CustomErrorCode
import com.zerobase.api.exception.CustomException
import com.zerobase.api.user.dto.InputUserInfoDto
import com.zerobase.api.user.dto.ReadUserInfoDto
import com.zerobase.api.user.util.UserKeyGenerator
import com.zerobase.domain.entity.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class UserInfoServiceImpl(
    private val userKeyGenerator: UserKeyGenerator,
    private val userInfoRepository: UserInfoRepository,
): UserInfoService {

    override fun userInfoMain(createRequest: InputUserInfoDto.CreateRequest
    ): InputUserInfoDto.CreateResponse {
        val userKey = userKeyGenerator.generateUserKey()

        saveUserInfo(createRequest, userKey)

        return InputUserInfoDto.CreateResponse(userKey)
    }
    override fun saveUserInfo(createRequest: InputUserInfoDto.CreateRequest, userKey: String) {
        userInfoRepository.save(createRequest.toEntity(userKey))
    }

    override fun getUserInfoDto(userKey: String): ReadUserInfoDto.ReadResponse {
        val userInfo = getUserInfo(userKey)

        return ReadUserInfoDto.ReadResponse.fromEntity(userInfo)
    }

    private fun getUserInfo(userKey: String): UserInfo {
        val userInfo = runCatching {
            userInfoRepository.findByUserKey(userKey)
        }.getOrElse {
            throw CustomException(CustomErrorCode.USER_NOT_FOUND)
        }
        return userInfo
    }
}