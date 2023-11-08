package com.zerobase.domain.enum
enum class OrganizationCode(
    val codeValue: String
) {
    NONE("00000"),
    ORGANIZATION_ONE("00001"),
    ORGANIZATION_TWO("00002");

    companion object {
        fun fromCodeValue(codeValue: String): OrganizationCode {
            for (enumValue in OrganizationCode.values()) {
                if (enumValue.codeValue == codeValue) {
                    return enumValue
                }
            }
            throw RuntimeException("convert 실패: 기관 코드가 일치하는 것이 없습니다.: $codeValue")
        }
    }
}