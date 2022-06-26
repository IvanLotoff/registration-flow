package ru.ivan.registrationflow.jpa

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class UserPhoneToUserIdPair(@Id val userPhone: String, val userId: String)
