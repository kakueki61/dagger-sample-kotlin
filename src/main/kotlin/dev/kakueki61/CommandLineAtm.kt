package dev.kakueki61

import dagger.Component
import dev.kakueki61.di.*
import java.util.*
import javax.inject.Singleton

class CommandLineAtm {
    companion object {
        @JvmStatic
        fun main(args : Array<String>) {
            println(args.joinToString())
            val commandProcessor = DaggerCommandLineAtm_CommandProcessorFactory.create().processor()
            val scanner = Scanner(System.`in`)
            while(scanner.hasNextLine()) {
                commandProcessor.process(scanner.nextLine())
            }
        }
    }

    @Singleton
    @Component(modules = [
        LoginCommandModule::class,
        UserCommandsRouter.InstallationModule::class,
        SystemOutModule::class
    ])
    interface CommandProcessorFactory {
        fun processor(): CommandProcessor
    }
}