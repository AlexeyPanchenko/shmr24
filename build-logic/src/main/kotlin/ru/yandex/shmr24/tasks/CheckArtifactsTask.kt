package ru.yandex.shmr24.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

abstract class CheckArtifactsTask : DefaultTask() {

    @get:InputDirectory
    abstract val apkDir: DirectoryProperty

    @TaskAction
    fun execute() {
        println("Path = ${apkDir.get().asFile.path}")
    }
}