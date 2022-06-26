package ru.ivan.registrationflow.superuser.openfeign

import feign.Headers
import feign.Response
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*


@FeignClient(
    name = "userClient",
    url = "\${superuser.users_url}",
)
interface UserRestService {

    @PostMapping
    fun createUser(
        @RequestHeader(value = "Authorization") authorization: String,
        @RequestBody form: Map<String, *>
    ): Response

    @PutMapping("/{id}")
    fun updateUser(
        @RequestHeader(value = "Authorization") authorization: String,
        @PathVariable id: String,
        @RequestBody form: Map<String, *>
    ): Response
}
