package ru.ivan.registrationflow

fun String.toAuthorizationHeader(): String {
    return "Bearer $this"
}
