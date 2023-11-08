package com.zerobase.domain.entity

import com.zerobase.domain.annotation.Encrypt
import javax.persistence.*

@Entity
@Table(name = "USER_INFO")
class UserInfo(
    @Column(name = "usr_key")
    val userKey: String,

    @Column(name = "usr_nm")
    val userName: String,

    @Column(name = "usr_icm_amt")
    val userIncomeAmount: Long,

    @Encrypt
    @Column(name = "usr_reg_num")
    val userRegistrationNumber: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}