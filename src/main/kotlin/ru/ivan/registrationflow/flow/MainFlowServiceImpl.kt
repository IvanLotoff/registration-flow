package ru.ivan.registrationflow.flow

import org.springframework.stereotype.Component
import ru.ivan.registrationflow.confirmationcode.CodeService
import ru.ivan.registrationflow.model.CodeConfirmationDto
import ru.ivan.registrationflow.superuser.abstraction.SuperUserService
import ru.ivan.registrationflow.model.RegistrationRequest

@Component
class MainFlowServiceImpl(
    private val codeService: CodeService,
    private val superUserService: SuperUserService
): MainFlowService {
    override fun startNewUserFlow(registrationRequest: RegistrationRequest) {
        codeService.issueCode(registrationRequest.phone)
        superUserService.registerNewUser(registrationRequest)
    }

    override fun confirmUserPhone(codeConfirmationDto: CodeConfirmationDto): Map<String, *>? {
        if(codeService.checkCode(codeConfirmationDto.phoneNumber, codeConfirmationDto.code)){
            return superUserService.enableUser(codeConfirmationDto.phoneNumber)
        }
        return null
    }
}
