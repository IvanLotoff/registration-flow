package ru.ivan.registrationflow.common

interface AuthService {
    fun authWithUsernameAndPassword(username: String, password: String): Map<String, *>
}
