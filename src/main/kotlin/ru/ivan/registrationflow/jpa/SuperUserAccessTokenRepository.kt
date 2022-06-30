package ru.ivan.registrationflow.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface SuperUserAccessTokenRepository: JpaRepository<SuperUserAccessToken, Int> {

    @Transactional
    @Modifying
    @Query("UPDATE SuperUserAccessToken superUser SET superUser.token=:accessToken where superUser.id=0")
    fun updateAccessToken(@Param("accessToken") accessToken: String)
}
