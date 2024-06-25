package ru.yandex.shmr24.core

import retrofit2.Response
import retrofit2.http.GET

class NetworkRepository(
    private val service: DogApiService
) {

    suspend fun getDogInfo(): Response<DogInfo> = service.getDogInfo()
}

interface DogApiService {
    @GET("/api/breeds/image/random")
    suspend fun getDogInfo(): Response<DogInfo>
}

class DogInfo(
    val message: String,
    val status: String
)
