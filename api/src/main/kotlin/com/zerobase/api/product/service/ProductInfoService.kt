package com.zerobase.api.product.service

import com.zerobase.api.product.dto.CreateProductDto
import com.zerobase.api.product.dto.ReadProductDto
import com.zerobase.domain.entity.ProductInfo
import com.zerobase.domain.enum.OrganizationCode

interface ProductInfoService {

    fun saveProductInfo(createProductRequest: CreateProductDto.CreateProductRequest): ProductInfo
    fun getProductInfoDto(organizationCode: OrganizationCode): List<ReadProductDto.ReadProductResponse>
    fun getProductInfo(organizationCode: OrganizationCode): List<ProductInfo>

    fun getProductListByOrgCdAndProdCd(productCode: String, organizationCode: String): List<ProductInfo>
}