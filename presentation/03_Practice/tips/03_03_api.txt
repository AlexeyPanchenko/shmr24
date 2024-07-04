package ru.yandex.shmr24.practice

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import java.io.File

private const val BASE_URL = "https://api.telegram.org"

class TelegramApi(
    private val httpClient: HttpClient,
) {

    suspend fun upload(file: File, token: String, chatId: String): HttpResponse {
        return httpClient.post("$BASE_URL/bot$token/sendDocument") {
            parameter("chat_id", chatId)
            setBody(
                MultiPartFormDataContent(
                    formData {
                        append("document", file.readBytes(), Headers.build {
                            append(HttpHeaders.ContentDisposition, "filename=${file.name.escapeIfNeeded()}")
                        })
                    }
                )
            )
        }
    }

    suspend fun sendMessage(message: String, token: String, chatId: String): HttpResponse {
        return httpClient.post("$BASE_URL/bot$token/sendMessage") {
            parameter("chat_id", chatId)
            parameter("text", message)
        }
    }
}