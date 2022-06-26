package ru.ivan.registrationflow.superuser

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.ivan.registrationflow.jpa.SuperUserAccessToken
import ru.ivan.registrationflow.jpa.SuperUserAccessTokenRepository
import ru.ivan.registrationflow.superuser.abstraction.SuperUserTokenStorageService

@Component
class SuperUserTokenStorageServiceImpl(private val superUserAccessTokenRepository: SuperUserAccessTokenRepository): SuperUserTokenStorageService {

    @Transactional
    override fun saveAccessToken(token: String) {
        // Здесь почему-то тригерится селект стейтмент
        superUserAccessTokenRepository.deleteAll()
        superUserAccessTokenRepository.save(
            SuperUserAccessToken(
                id = 0,
                token = token
            )
        )
    }

    override fun getAccessToken() = superUserAccessTokenRepository
        .findById(0)
        .get()
        .token
}
