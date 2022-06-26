package ru.ivan.registrationflow.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface SuperUserAccessTokenRepository: JpaRepository<SuperUserAccessToken, Int>
