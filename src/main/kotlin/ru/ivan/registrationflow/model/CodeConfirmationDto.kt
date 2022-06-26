package ru.ivan.registrationflow.model

data class CodeConfirmationDto(
    val phoneNumber: String,
    val code: String
)
