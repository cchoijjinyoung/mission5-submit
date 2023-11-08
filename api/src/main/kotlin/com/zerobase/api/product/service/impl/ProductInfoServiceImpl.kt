package com.zerobase.api.product.service.impl

import com.zerobase.api.exception.CustomErrorCode
import com.zerobase.api.exception.CustomException
import com.zerobase.api.product.dto.CreateProductDto
import com.zerobase.api.product.dto.ReadProductDto
import com.zerobase.api.product.service.ProductInfoService
import com.zerobase.domain.entity.ProductInfo
import com.zerobase.domain.enum.OrganizationCode
import com.zerobase.domain.enum.ProductCode
import com.zerobase.domain.repository.ProductInfoRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ProductInfoServiceImpl(
    private val productInfoRepository: ProductInfoRepository,
): ProductInfoService {
    override fun saveProductInfo(createProductRequest: CreateProductDto.CreateProductRequest):ProductInfo {
        if (getProductListByOrgCdAndProdCd(
                createProductRequest.productCode, createProductRequest.organizationCode).isNotEmpty()) {
            throw CustomException(CustomErrorCode.ALREADY_EXIST_PRODUCT_IN_ORGANIZATION)
        }
        return productInfoRepository.save(createProductRequest.toEntity())
    }

    override fun getProductListByOrgCdAndProdCd(productCode: String, organizationCode: String): List<ProductInfo> {
        return productInfoRepository.findByProductCodeAndOrganizationCode(
            ProductCode.fromCodeValue(productCode), OrganizationCode.fromCodeValue(organizationCode))
    }

    override fun getProductInfoDto(
        organizationCode: OrganizationCode
    ): List<ReadProductDto.ReadProductResponse> {
        val productInfos: List<ProductInfo> = getProductInfo(organizationCode)

        val result: MutableList<ReadProductDto.ReadProductResponse> = mutableListOf()

        for (productInfo in productInfos) {
           result.add(ReadProductDto.ReadProductResponse.fromEntity(productInfo))
        }
        return result
    }
    @Cacheable(value = ["PRODUCTS_BY_ORG_CD"], key = "#organizationCode", cacheManager = "redisCacheManager")
    override fun getProductInfo(
        organizationCode: OrganizationCode
    ): List<ProductInfo> {
        return productInfoRepository.findAllByOrganizationCode(organizationCode)
    }
}