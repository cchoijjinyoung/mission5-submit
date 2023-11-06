package com.zerobase.api.product.dto

class ProductReadDto {

    data class ReadRequest(
        val organizationCode: String,
        val productCode: String,
        val productMaximumInterest: Double,
        val productMinimumInterest: Double,
        val productName: String
    )
}