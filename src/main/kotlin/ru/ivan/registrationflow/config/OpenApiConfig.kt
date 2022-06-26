package ru.ivan.registrationflow.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info


@OpenAPIDefinition(info = Info(
    title = "Registration Flow",
    description = "Микросервис для регистрации новых пользователей",
    version = "v1")
)
class OpenApiConfig
