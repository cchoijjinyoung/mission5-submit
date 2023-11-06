package com.zerobase.api.common

class FintechResponse (
    private val data: Any?,
    private val customResponseCode: CustomResponseCode
) {
    fun toResponseDto(): ResponseDto {
        return ResponseDto(
            data = this.data,
            responseCode = customResponseCode.responseCode,
            responseMessage = customResponseCode.responseMessage
        )
    }

    data class ResponseDto(
        val data: Any?,
        val responseCode: String,
        val responseMessage: String
    )
}