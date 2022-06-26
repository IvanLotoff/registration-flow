package ru.ivan.registrationflow.superuser.abstraction

interface UserIdentityStorageService {
    fun saveUserPhone(phone: String, userId: String)
    fun findUserIdByPhone(phone: String): String?
}
