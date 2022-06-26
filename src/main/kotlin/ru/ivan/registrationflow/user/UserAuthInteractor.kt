package ru.ivan.registrationflow.user

interface UserAuthInteractor {
    /**
     * Получаем access и refresh токены пользователя
     */
    fun getTokens(userPhone: String): Map<String, *>
}
