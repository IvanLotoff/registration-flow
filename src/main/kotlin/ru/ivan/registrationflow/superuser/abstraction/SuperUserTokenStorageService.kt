package ru.ivan.registrationflow.superuser.abstraction

/**
 * Интерфейс, который отвечает за "запоминание" access токена суперюзера
 */
interface SuperUserTokenStorageService {
    /**
     * Запоминаем access токен
     */
    fun saveAccessToken(token: String)

    /**
     * получаем последний access токен
     */
    fun getAccessToken(): String?
}
