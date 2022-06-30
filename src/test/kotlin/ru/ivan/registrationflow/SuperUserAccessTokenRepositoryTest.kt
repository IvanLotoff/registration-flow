package ru.ivan.registrationflow

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.ivan.registrationflow.annotation.H2DatabaseTest
import ru.ivan.registrationflow.jpa.SuperUserAccessToken
import ru.ivan.registrationflow.jpa.SuperUserAccessTokenRepository

@H2DatabaseTest
class SuperUserAccessTokenRepositoryTest {
    @Autowired
    private lateinit var superUserAccessTokenRepository: SuperUserAccessTokenRepository

    @BeforeEach
    fun initRepository() {
        superUserAccessTokenRepository.save(
            SuperUserAccessToken(
                id = 0,
                token = "initial"
            )
        )
    }

    @Test
    fun successfulUpdate() {
        // given
        // when
        superUserAccessTokenRepository.updateAccessToken(NEW_TOKEN)

        // then
        val findById = superUserAccessTokenRepository.findById(0).get()
        assert(findById.token == NEW_TOKEN)
    }
}

const val NEW_TOKEN = "newToken"
