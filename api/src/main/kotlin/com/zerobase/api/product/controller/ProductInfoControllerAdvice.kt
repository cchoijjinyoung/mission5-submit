package com.zerobase.api.product.controller

import com.zerobase.api.exception.CustomException
import com.zerobase.api.exception.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackageClasses = [ProductInfoController::class])
class ProductInfoControllerAdvice {

    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(customException: CustomException) =
        ErrorResponse(customException).toResponseEntity()
}