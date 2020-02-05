package dev.kakueki61.di

import dagger.Component
import dev.kakueki61.CommandRouter

@Component(modules = [HelloWorldModule::class, SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}