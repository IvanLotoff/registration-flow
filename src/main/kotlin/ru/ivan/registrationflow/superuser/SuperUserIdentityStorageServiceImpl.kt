package ru.ivan.registrationflow.superuser

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.ivan.registrationflow.superuser.abstraction.SuperUserIdentityStorageService
import ru.ivan.registrationflow.model.SuperUserModel

@Component
class SuperUserIdentityStorageServiceImpl: SuperUserIdentityStorageService {
    @Value("\${superuser.client_id}")
    private val clientId: String? = null

    override fun getSuperUserIdentity(): SuperUserModel {
        return SuperUserModel(
            username = "ivan-main-user",
            password = "ghbdtn12"
        )
    }

    override fun getClientId() = clientId!!

    override fun getGrantType() = "password"
}
