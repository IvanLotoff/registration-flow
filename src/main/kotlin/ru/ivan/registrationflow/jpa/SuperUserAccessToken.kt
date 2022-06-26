package ru.ivan.registrationflow.jpa

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table

@Entity
@Table(name = "super_user_access_token")
class SuperUserAccessToken(
    @Id val id: Int,
    @Lob val token: String
)
