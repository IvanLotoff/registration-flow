package ru.ivan.registrationflow.superuser

import org.springframework.stereotype.Component
import ru.ivan.registrationflow.jpa.UserPhoneToUserIdPair
import ru.ivan.registrationflow.jpa.UserPhoneToUserIdPairRepository
import ru.ivan.registrationflow.superuser.abstraction.UserIdentityStorageService

@Component
class UserIdentityStorageServiceImpl(
    private val userPhoneToUserIdPair : UserPhoneToUserIdPairRepository
): UserIdentityStorageService {

    override fun saveUserPhone(phone: String, userId: String) {
        userPhoneToUserIdPair.save(
            UserPhoneToUserIdPair(
                userPhone = phone,
                userId = userId
            )
        )
    }

    override fun findUserIdByPhone(phone: String): String? {
        return userPhoneToUserIdPair.findById(phone).get().userId
    }
}
