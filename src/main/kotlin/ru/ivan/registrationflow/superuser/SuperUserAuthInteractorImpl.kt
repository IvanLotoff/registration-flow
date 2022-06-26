package ru.ivan.registrationflow.superuser

import org.springframework.stereotype.Component
import ru.ivan.registrationflow.superuser.abstraction.SuperUserTokenStorageService
import ru.ivan.registrationflow.superuser.abstraction.SuperUserAuthInteractor
import ru.ivan.registrationflow.superuser.abstraction.SuperUserIdentityStorageService
import ru.ivan.registrationflow.superuser.openfeign.AuthRestService

@Component
class SuperUserAuthInteractorImpl(
    val superUserTokenStorageService: SuperUserTokenStorageService,
    val authRestService: AuthRestService,
    val superUserIdentityStorageService: SuperUserIdentityStorageService
) : SuperUserAuthInteractor {

    override fun getLastAccessToken(): String? {
        return superUserTokenStorageService.getAccessToken()
    }

    override fun updateAccessToken(): String {
        val (username, password) = superUserIdentityStorageService.getSuperUserIdentity()
        val client = superUserIdentityStorageService.getClientId()
        val grantType = superUserIdentityStorageService.getGrantType()
        val accessToken = authRestService.auth(
            mapOf(
                "password" to password,
                "username" to username,
                "client_id" to client,
                "grant_type" to grantType
            )
        )["access_token"] as String
        superUserTokenStorageService.saveAccessToken(accessToken)
        return accessToken
    }

}
