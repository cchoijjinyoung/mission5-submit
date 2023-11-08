package com.zerobase.api.product.dto

import com.zerobase.domain.entity.ProductInfo
import io.swagger.annotations.ApiModelProperty

class ReadProductDto {

    data class ReadProductResponse(
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
        companion object {
            fun fromEntity(productInfo: ProductInfo): ReadProductDto.ReadProductResponse {
                return ReadProductDto.ReadProductResponse(
                    organizationCode = productInfo.organizationCode.codeValue,
                    productCode = productInfo.productCode.codeValue,
                    productMaximumInterest = productInfo.productMaximumInterest,
                    productMinimumInterest = productInfo.productMinimumInterest,
                    productName = productInfo.productName
                )
            }
        }
    }

}