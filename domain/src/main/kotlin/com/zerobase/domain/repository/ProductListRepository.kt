package com.zerobase.domain.repository

import com.zerobase.domain.entity.ProductInfo
import com.zerobase.domain.enum.OrganizationCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductInfoRepository: JpaRepository<ProductInfo, Long> {
    fun findAllByOrganizationCode(organizationCode: OrganizationCode): List<ProductInfo>

}
