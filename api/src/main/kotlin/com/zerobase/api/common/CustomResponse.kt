package com.zerobase.api.common

import io.swagger.annotations.ApiModelProperty

class CustomResponse (
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

        @ApiModelProperty(example = "00")
        val responseCode: String,

        @ApiModelProperty(example = "success")
        val responseMessage: String
    )
}