package ru.ivan.registrationflow.superuser.abstraction

/**
 * Интерфейс для взаимодействия между суперпользователем и хранилищем пользователей
 */
interface SuperUserAuthInteractor {
    /**
     * Получаем последний токен доступа суперпользователя
     */
    fun getLastAccessToken(): String?

    /**
     * Обновляем access токен
     */
    fun updateAccessToken(): String
}
