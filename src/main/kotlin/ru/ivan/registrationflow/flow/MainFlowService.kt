package ru.ivan.registrationflow.flow

import ru.ivan.registrationflow.model.CodeConfirmationDto
import ru.ivan.registrationflow.model.RegistrationRequest

/**
 * Самый главный сервис, который отвечает за регистрационное флоу
 * Именно этот сервис доступен с контроллеров
 */
interface MainFlowService {
    fun startNewUserFlow(registrationRequest: RegistrationRequest)
    fun confirmUserPhone(codeConfirmationDto: CodeConfirmationDto): Map<String, *>?
}
