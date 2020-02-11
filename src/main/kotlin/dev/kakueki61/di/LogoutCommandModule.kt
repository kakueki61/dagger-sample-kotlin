package dev.kakueki61.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import dev.kakueki61.command.Command
import dev.kakueki61.command.LogoutCommand

@Module
abstract class LogoutCommandModule {
    @Binds
    @IntoMap
    @StringKey("logout")
    abstract fun logoutCommand(logoutCommand: LogoutCommand): Command
}