package com.zerobase.api.common

import io.swagger.annotations.ApiModelProperty

enum class CustomResponseCode(
    @ApiModelProperty(example = "00")
    val responseCode: String,

    @ApiModelProperty(example = "success")
    val responseMessage: String
) {
    SUCCESS("00", "success")
}