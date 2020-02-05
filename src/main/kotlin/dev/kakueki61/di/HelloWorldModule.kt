package dev.kakueki61.di

import dagger.Binds
import dagger.Module
import dev.kakueki61.Command
import dev.kakueki61.HelloWorldCommand

@Module
abstract class HelloWorldModule {
    @Binds
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}