package ru.ivan.registrationflow.user

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.ivan.registrationflow.common.AuthService

@Component
class UserAuthInteractorImpl(private val authService: AuthService): UserAuthInteractor {
    @Value("\${superuser.mock_password}")
    private val password: String? = null

    override fun getTokens(userPhone: String): Map<String, *> {
        return authService.authWithUsernameAndPassword(userPhone, password!!)
    }
}
