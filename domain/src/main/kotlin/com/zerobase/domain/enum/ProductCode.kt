package com.zerobase.domain.enum

enum class ProductCode(
    val codeValue: String
) {
    NONE("000"),
    PRODUCT_ONE("001"),
    PRODUCT_TWO("002");

    companion object {
        fun fromCodeValue(codeValue: String): ProductCode {
            for (enumValue in values()) {
                if (enumValue.codeValue == codeValue) {
                    return enumValue
                }
            }
            throw RuntimeException("convert 실패: 상품 코드가 일치하는 것이 없습니다.: $codeValue")
        }
    }
}