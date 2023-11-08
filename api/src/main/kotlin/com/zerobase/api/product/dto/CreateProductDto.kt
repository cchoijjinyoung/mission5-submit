package com.zerobase.api.product.dto

import com.zerobase.domain.entity.ProductInfo
import com.zerobase.domain.enum.OrganizationCode
import com.zerobase.domain.enum.ProductCode
import io.swagger.annotations.ApiModelProperty

class CreateProductDto {
    data class CreateProductRequest(
        @ApiModelProperty(example = "00001")
        val organizationCode: String,

        @ApiModelProperty(example = "001")
        val productCode: String,

        @ApiModelProperty(example = "9.9")
        val productMaximumInterest: Double,

        @ApiModelProperty(example = "1.1")
        val productMinimumInterest: Double,

        @ApiModelProperty(example = "상품 1")
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