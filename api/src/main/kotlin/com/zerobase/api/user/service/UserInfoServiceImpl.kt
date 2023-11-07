package com.zerobase.api.user.service.impl

import com.zerobase.api.user.dto.InputUserInfoDto
import com.zerobase.api.user.dto.ReadUserInfoDto
import com.zerobase.api.user.encrypt.EncryptComponent
import com.zerobase.api.user.util.UserKeyGenerator
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class UserInfoServiceImpl(
    private val userKeyGenerator: UserKeyGenerator,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent
): UserInfoService {

    override fun userInfoMain(createRequest: InputUserInfoDto.CreateRequest
    ): InputUserInfoDto.CreateResponse {
        val userKey = userKeyGenerator.generateUserKey()

        createRequest.userRegistrationNumber =
            encryptComponent.encryptString(createRequest.userRegistrationNumber)
        saveUserInfo(createRequest, userKey)

        return InputUserInfoDto.CreateResponse(userKey)
    }
    override fun saveUserInfo(createRequest: InputUserInfoDto.CreateRequest, userKey: String) {
        val userInfo = createRequest.toEntity(userKey)
        userInfoRepository.save(userInfo)
    }

    override fun getUserInfo(userKey: String): ReadUserInfoDto.ReadResponse {
        val userInfo = userInfoRepository.findByUserKey(userKey)

        val userInfoResponseDto = ReadUserInfoDto.ReadResponse.fromEntity(userInfo)

        userInfoResponseDto.userRegistrationNumber =
            encryptComponent.decryptString(userInfoResponseDto.userRegistrationNumber)

        return userInfoResponseDto
    }
}