package com.zerobase.api.aop

import com.zerobase.api.user.encrypt.EncryptComponent
import com.zerobase.domain.annotation.Encrypt
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.lang.reflect.Field

@Component
@Aspect
class EncryptAspect(
    private val encryptComponent: EncryptComponent
) {

    @Pointcut("execution(* com.zerobase.domain..repository.*.save*(..))")
    fun saveMethod() {}

    @Pointcut("execution(* com.zerobase.domain..repository.*.find*(..))")
    fun findMethod() {}

    @Around("saveMethod()")
    fun encryptOnSave(joinPoint: ProceedingJoinPoint): Any? {
        val target = joinPoint.args[0]
        val targetClass = target.javaClass

        val encryptFields = getEncryptFields(targetClass)

        if (encryptFields.isNotEmpty()) {
            for (field in encryptFields) {
                field.isAccessible = true
                val fieldValue = field.get(target)

                if (fieldValue is String) {
                    val encryptValue = encryptComponent.encryptString(fieldValue)
                    field.set(target, encryptValue)
                }
            }
        }
        return joinPoint.proceed()
    }

    @Around("findMethod()")
    fun decryptOnFind(joinPoint: ProceedingJoinPoint): Any? {
        val result = joinPoint.proceed()
        val targetClass = result.javaClass

        val encryptFields = getEncryptFields(targetClass)

        if (encryptFields.isNotEmpty()) {
            for (field in encryptFields) {
                field.isAccessible = true
                val fieldValue = field.get(result)

                if (fieldValue is String) {
                    val decryptValue = encryptComponent.decryptString(fieldValue)
                    field.set(result, decryptValue)
                }
            }
        }
        return result
    }

    private fun getEncryptFields(targetClass: Class<Any>): List<Field> {
        return targetClass.declaredFields.filter { field ->
            field.isAnnotationPresent(Encrypt::class.java)
        }
    }
}