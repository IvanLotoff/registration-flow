package ru.ivan.registrationflow.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.ivan.registrationflow.flow.MainFlowService
import ru.ivan.registrationflow.model.CodeConfirmationDto
import ru.ivan.registrationflow.model.RegistrationRequest

@RestController
class RegistrationController(private val mainFlowService: MainFlowService) {

    @PostMapping("/new")
    fun startNewUserFlow(@RequestBody registrationRequest: RegistrationRequest) {
        mainFlowService.startNewUserFlow(registrationRequest)
    }

    @PostMapping("/confirm")
    fun confirmCode(@RequestBody codeConfirmationDto: CodeConfirmationDto): Map<String, *> {
        return mainFlowService.confirmUserPhone(codeConfirmationDto)
            ?: throw RuntimeException("Failed to confirm")
    }
}
