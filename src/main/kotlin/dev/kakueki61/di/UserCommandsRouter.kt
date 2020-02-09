package dev.kakueki61.di

import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dev.kakueki61.CommandRouter
import dev.kakueki61.Database

@Subcomponent(modules = [UserCommandsModule::class])
interface UserCommandsRouter {
    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance account: Database.Account): UserCommandsRouter
    }

    @Module(subcomponents = [UserCommandsRouter::class])
    interface InstallationModule
}