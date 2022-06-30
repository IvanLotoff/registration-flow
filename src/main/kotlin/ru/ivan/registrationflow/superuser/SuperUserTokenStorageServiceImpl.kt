package ru.ivan.registrationflow.superuser

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.ivan.registrationflow.jpa.SuperUserAccessToken
import ru.ivan.registrationflow.jpa.SuperUserAccessTokenRepository
import ru.ivan.registrationflow.superuser.abstraction.SuperUserTokenStorageService

@Component
class SuperUserTokenStorageServiceImpl(private val superUserAccessTokenRepository: SuperUserAccessTokenRepository): SuperUserTokenStorageService {

    override fun saveAccessToken(token: String) {
        superUserAccessTokenRepository.updateAccessToken(token)
    }

    override fun getAccessToken() = superUserAccessTokenRepository
        .findById(0)
        .get()
        .token
}
