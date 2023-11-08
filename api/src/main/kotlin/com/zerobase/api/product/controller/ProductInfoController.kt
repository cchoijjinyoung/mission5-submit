package com.zerobase.api.product.controller

import com.zerobase.api.common.CustomResponse
import com.zerobase.api.common.CustomResponseCode
import com.zerobase.api.product.dto.CreateProductDto
import com.zerobase.api.product.service.ProductInfoService
import com.zerobase.domain.enum.OrganizationCode
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/v1/product")
@Api(description = "상품 정보 API")
class ProductInfoController(
    private val productInfoService: ProductInfoService
) {

    @PostMapping("/information")
    @ApiOperation(value = "상품 정보 수신 API", notes = "금융사로부터 상품 정보를 받는 API")
    fun saveProductInfo(@RequestBody createProductRequest: CreateProductDto.CreateProductRequest
    ): CustomResponse.ResponseDto {
        productInfoService.saveProductInfo(createProductRequest)
        return CustomResponse(null, CustomResponseCode.SUCCESS).toResponseDto()
    }

    @GetMapping("/{organizationCode}")
    @ApiOperation(value = "상품 정보 조회 API", notes = "상품 정보를 조회하는 API")
    fun getProductInfo(@PathVariable organizationCode: OrganizationCode
    ): CustomResponse.ResponseDto {
        val data = productInfoService.getProductInfoDto(organizationCode)
        return CustomResponse(data, CustomResponseCode.SUCCESS).toResponseDto()
    }
}