package ru.yandex.shmr24.tasks

import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

abstract class TaskWithDependencies @Inject constructor(
    private val repository: Repository
) : DefaultTask() {

    @get:Input
    abstract val prefix: Property<String>

    @TaskAction
    fun execute() {
        val data = runBlocking {
            repository.getData()
        }
        println("${prefix.get()} $data")
    }

}

class Repository {

    suspend fun getData() = "Random data = ${(0..100).random()}"
}