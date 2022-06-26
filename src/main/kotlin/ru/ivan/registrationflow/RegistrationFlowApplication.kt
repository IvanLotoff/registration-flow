package ru.ivan.registrationflow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import ru.ivan.registrationflow.superuser.abstraction.SuperUserService
import ru.ivan.registrationflow.model.RegistrationRequest

@EnableWebMvc
@SpringBootApplication
@EnableFeignClients
class RegistrationFlowApplication

fun main(args: Array<String>) {
	runApplication<RegistrationFlowApplication>(*args)
}
