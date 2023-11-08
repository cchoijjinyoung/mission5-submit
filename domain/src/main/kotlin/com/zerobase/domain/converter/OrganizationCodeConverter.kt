package com.zerobase.domain.converter

import com.zerobase.domain.enum.OrganizationCode
import javax.persistence.AttributeConverter

class OrganizationCodeConverter: AttributeConverter<OrganizationCode, String> {
    override fun convertToDatabaseColumn(attribute: OrganizationCode?): String {
        if (attribute == null) {
            throw RuntimeException("기관 코드는 NULL로 저장할 수 없습니다.")
        }
        return attribute.codeValue
    }

    override fun convertToEntityAttribute(dbData: String?): OrganizationCode {
        if (dbData == null) {
            throw RuntimeException("기관 코드가 DB에 null이나 Empty로 저장되어 있습니다.")
        }
        return OrganizationCode.fromCodeValue(dbData)
    }
}