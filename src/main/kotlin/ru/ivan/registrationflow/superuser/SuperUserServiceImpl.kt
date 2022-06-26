package ru.ivan.registrationflow.superuser

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.ivan.registrationflow.superuser.abstraction.SuperUserAuthInteractor
import ru.ivan.registrationflow.superuser.abstraction.SuperUserService
import ru.ivan.registrationflow.superuser.abstraction.UserIdentityStorageService
import ru.ivan.registrationflow.model.RegistrationRequest
import ru.ivan.registrationflow.superuser.openfeign.UserRestService
import ru.ivan.registrationflow.toAuthorizationHeader
import ru.ivan.registrationflow.user.UserAuthInteractor

@Component
class SuperUserServiceImpl(
    private val userIdentityStorageService: UserIdentityStorageService,
    private val superUserAuthInteractor: SuperUserAuthInteractor,
    private val userRestService: UserRestService,
    private val userAuthInteractor: UserAuthInteractor,
) : SuperUserService {
    @Value("\${superuser.mock_password}")
    private val password: String? = null

    override fun registerNewUser(request: RegistrationRequest): String? {
        val accessToken = superUserAuthInteractor.updateAccessToken()
        val response = userRestService.createUser(
            accessToken.toAuthorizationHeader(),
            createUserRequestMap(request.phone, request.name)
        )
        if(response.status() != 201)
            throw RuntimeException("User Already exist")
        val mutableCollection: MutableCollection<String>? = response.headers()["location"]
        val id = mutableCollection?.elementAt(0)?.split("/")?.last()
        if (id != null)
            userIdentityStorageService.saveUserPhone(request.phone, id)
        return id
    }

    override fun enableUser(userPhone: String): Map<String, *>? {
        val userId = userIdentityStorageService.findUserIdByPhone(userPhone)
        if (userId != null) {
            // По идее, здесь никогда не может быть null
            val lastAccessToken = superUserAuthInteractor.getLastAccessToken()!!
            if (!updateWithAccessToken(userId, lastAccessToken)) {
                val accessToken = superUserAuthInteractor.updateAccessToken()
                updateWithAccessToken(userId, accessToken)
            }
            return userAuthInteractor.getTokens(userPhone)
        }
        return null
    }

    private fun updateWithAccessToken(id: String, accessToken: String): Boolean {
        val response = userRestService.updateUser(
            accessToken.toAuthorizationHeader(),
            id,
            getUpdateUserBody()
        )
        return response.status() == 204
    }

    private fun getUpdateUserBody() = mapOf(
        "enabled" to true
    )

    private fun createUserRequestMap(
        phone: String,
        name: String
    ): Map<String, *> {
        return mapOf(
            "username" to phone,
            "firstName" to name,
            "groups" to listOf("users"),
            "credentials" to listOf(
                Credentials(
                    temporary = false,
                    type = "password",
                    value = password!!
                )
            )
        )
    }

    private data class Credentials(
        val temporary: Boolean,
        val type: String,
        val value: String
    )
}
