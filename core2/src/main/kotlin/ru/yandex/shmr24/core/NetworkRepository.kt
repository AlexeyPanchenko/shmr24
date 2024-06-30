package ru.yandex.shmr24.core

import retrofit2.Response
import retrofit2.http.GET
import ru.yandex.shmr24.model.DogInfo
import ru.yandex.shmr24.model.DogInfo2

// core2
class NetworkRepository(
    private val service: DogApiService
) {

    suspend fun getDogInfo(): Response<DogInfo> = Response.success(DogInfo("stub message", "stub"))
    suspend fun getDogInfo2(): Response<DogInfo2> = Response.success(DogInfo2("stub message", "stub"))
}

interface DogApiService {
    @GET("/api/breeds/image/random")
    suspend fun getDogInfo(): Response<DogInfo>
}
