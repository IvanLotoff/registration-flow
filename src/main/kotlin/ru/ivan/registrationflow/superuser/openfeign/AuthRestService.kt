package ru.ivan.registrationflow.superuser.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import ru.ivan.registrationflow.superuser.config.OpenFeignConfig

@FeignClient(
    name = "SuperUserAuth",
    url = "\${superuser.auth_url}",
    configuration = [OpenFeignConfig::class]
)
interface AuthRestService {

    @PostMapping(
        consumes = [APPLICATION_FORM_URLENCODED_VALUE]
    )
    fun auth(@RequestBody form: Map<String, *>): Map<String, *>
}
