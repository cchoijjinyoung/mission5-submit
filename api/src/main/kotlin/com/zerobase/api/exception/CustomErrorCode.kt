package com.zerobase.api.exception

import org.springframework.http.HttpStatus

enum class CustomErrorCode(
    val statusCode: HttpStatus,
    val errorCode: String,
    val errorMessage: String
) {

    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "E101", errorMessage = "존재하지 않는 유저입니다."),

    ALREADY_EXIST_PRODUCT_IN_ORGANIZATION(HttpStatus.BAD_REQUEST, "E202", errorMessage = "이미 같은 기관에 동일한 상품이 존재합니다.")
}