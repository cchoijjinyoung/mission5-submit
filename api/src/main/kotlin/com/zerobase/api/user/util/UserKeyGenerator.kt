package com.zerobase.api.user.util

import org.springframework.stereotype.Component
import java.util.*

@Component
class UserKeyGenerator {
    fun generateUserKey() = UUID.randomUUID().toString().replace("-", "")
}