package ru.yandex.shmr24.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class SayHelloUserTask : DefaultTask() {

    @get:InputFile
    abstract val userNameFile: RegularFileProperty

    @TaskAction
    fun execute() {
        val userName = userNameFile.get().asFile.readText()
        println("Hello $userName")
    }
}

abstract class GenerateNameTask : DefaultTask() {

    @get:OutputFile
    abstract val userNameFile: RegularFileProperty

    @TaskAction
    fun execute() {
        val name = "User ${(0..100).random()}"
        userNameFile.asFile.get().writeText(name)
    }
}