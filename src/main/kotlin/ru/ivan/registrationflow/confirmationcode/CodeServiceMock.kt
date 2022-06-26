package ru.ivan.registrationflow.confirmationcode

import org.springframework.stereotype.Component

@Component
class CodeServiceMock: CodeService {
    override fun issueCode(phoneNumber: String) {
        println("Sms code has been issued!")
    }

    override fun checkCode(phoneNumber: String, code: String): Boolean {
        return code == "1234"
    }
}
