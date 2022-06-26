package ru.ivan.registrationflow.confirmationcode

interface CodeService {
    /**
     * Method that issues code such as sends sms to the phone number
     */
    fun issueCode(phoneNumber: String)

    /**
     * return true if the code is correct and false otherwise
     */
    fun checkCode(phoneNumber: String, code: String): Boolean
}
