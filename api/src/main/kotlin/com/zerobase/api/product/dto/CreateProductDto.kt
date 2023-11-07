package com.zerobase.api.product.dto

import com.zerobase.domain.entity.ProductInfo
import com.zerobase.domain.enum.OrganizationCode
import com.zerobase.domain.enum.ProductCode

class InputProductDto {
    data class CreateRequest(
        val organizationCode: String,
        val productCode: String,
        val productMaximumInterest: Double,
        val productMinimumInterest: Double,
        val productName: String
    ) {
        fun toEntity(): ProductInfo {
            return ProductInfo(
                organizationCode = OrganizationCode.fromCodeValue(this.organizationCode),
                productCode = ProductCode.fromCodeValue(this.productCode),
                productMaximumInterest = this.productMaximumInterest,
                productMinimumInterest = this.productMinimumInterest,
                productName = this.productName
            )
        }
    }
}