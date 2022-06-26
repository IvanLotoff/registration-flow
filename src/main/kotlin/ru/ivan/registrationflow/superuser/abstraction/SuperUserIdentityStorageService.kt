package ru.ivan.registrationflow.superuser.abstraction

import ru.ivan.registrationflow.model.SuperUserModel

/**
 * Получаем логин и пароль супер-пользователя
 */
interface SuperUserIdentityStorageService {
    fun getSuperUserIdentity(): SuperUserModel
    fun getClientId(): String
    fun getGrantType(): String
}
