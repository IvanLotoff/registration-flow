package ru.ivan.registrationflow.superuser.config

import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import feign.Logger

@Configuration
class OpenFeignConfig {

    @Bean
    fun feignFormEncoder(converters: ObjectFactory<HttpMessageConverters?>?): Encoder {
        return SpringFormEncoder(SpringEncoder(converters))
    }

    @Bean
    fun feignLoggerLevel(): Logger.Level? {
        return Logger.Level.FULL
    }
}
