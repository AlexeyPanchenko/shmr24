package ru.yandex.shmr24.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class PrintHelloTask : DefaultTask() {

    @TaskAction
    fun execute() {
        println("Hello")
    }
}

abstract class PrintUserNameTask : DefaultTask() {

    @TaskAction
    fun execute() {
        println("UserName")
    }
}