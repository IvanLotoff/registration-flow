package ru.ivan.registrationflow.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.ivan.registrationflow.superuser.openfeign.AuthRestService

@Component
class AuthServiceImpl(
    private val authRestService: AuthRestService
): AuthService {
    @Value("\${superuser.client_id}")
    private val clientId: String? = null

    override fun authWithUsernameAndPassword(username: String, password: String): Map<String, *> {
        return authRestService.auth(createUsernamePasswordMap(username, password))
    }

    private fun createUsernamePasswordMap(username: String, password: String): Map<String, *> {
        return mapOf(
			"password" to password,
			"username" to username,
			"client_id" to clientId,
			"grant_type" to "password"
		)
    }
}
