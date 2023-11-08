package com.zerobase.domain.entity

import com.zerobase.domain.converter.OrganizationCodeConverter
import com.zerobase.domain.converter.ProductCodeConverter
import com.zerobase.domain.enum.OrganizationCode
import com.zerobase.domain.enum.ProductCode
import javax.persistence.*

@Entity
@Table(name = "PRODUCT_INFO")
class ProductInfo(

    @Convert(converter = OrganizationCodeConverter::class)
    @Column(name = "org_cd")
    val organizationCode: OrganizationCode,

    @Convert(converter = ProductCodeConverter::class)
    @Column(name = "prod_cd")
    val productCode: ProductCode,

    @Column(name = "prod_max_intr")
    val productMaximumInterest: Double,

    @Column(name = "prod_min_intr")
    val productMinimumInterest: Double,

    @Column(name = "prod_nm")
    val productName: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}