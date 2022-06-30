package ru.ivan.registrationflow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import ru.ivan.registrationflow.jpa.SuperUserAccessToken
import ru.ivan.registrationflow.jpa.SuperUserAccessTokenRepository
import ru.ivan.registrationflow.superuser.abstraction.SuperUserService
import ru.ivan.registrationflow.model.RegistrationRequest

@EnableWebMvc
@SpringBootApplication
@EnableFeignClients
class RegistrationFlowApplication

fun main(args: Array<String>) {
	val context = runApplication<RegistrationFlowApplication>(*args)
	val repository = context.getBean(SuperUserAccessTokenRepository::class.java)
	repository.save(
		SuperUserAccessToken(
			id = 0,
			token = "initial"
		)
	)
}
