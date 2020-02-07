package dev.kakueki61.di

import dagger.Component
import dev.kakueki61.CommandRouter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    LoginCommandModule::class,
    HelloWorldModule::class,
    UserCommandsModule::class,
    SystemOutModule::class
])
interface CommandRouterFactory {
    fun router(): CommandRouter
}