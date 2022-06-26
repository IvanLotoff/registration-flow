package ru.ivan.registrationflow.superuser.abstraction

import ru.ivan.registrationflow.model.RegistrationRequest

interface SuperUserService {
    /**
     * регистрируем новго пользователя с ролью [ROLE_USER] и возвращаем его id
     */
    fun registerNewUser(request: RegistrationRequest): String?

    /**
     * меняем состояние пользователя на enabled и возвращаем пару токенов
     */
    fun enableUser(userPhone: String):  Map<String, *>?
}
