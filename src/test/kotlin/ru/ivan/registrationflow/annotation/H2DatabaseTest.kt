package ru.ivan.registrationflow.annotation

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*


@Target(CLASS)
@Retention(RUNTIME)
@SpringBootTest
@ActiveProfiles("h2")
annotation class H2DatabaseTest
