package com.zerobase.domain.converter

import com.zerobase.domain.enum.ProductCode
import javax.persistence.AttributeConverter

class ProductCodeConverter: AttributeConverter<ProductCode, String> {
    override fun convertToDatabaseColumn(attribute: ProductCode?): String {
        if (attribute == null) {
            throw RuntimeException("상품 코드는 NULL로 저장할 수 없습니다.")
        }
        return attribute.codeValue
    }

    override fun convertToEntityAttribute(dbData: String?): ProductCode {
        if (dbData == null) {
            throw RuntimeException("상품 코드가 DB에 null이나 Empty로 저장되어 있습니다.")
        }
        return ProductCode.fromCodeValue(dbData)
    }
}
