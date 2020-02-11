package dev.kakueki61.di

import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import dev.kakueki61.Database
import dev.kakueki61.command.Command
import dev.kakueki61.command.LoginCommand

@Module
abstract class LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    abstract fun loginCommand(loginCommand: LoginCommand): Command

    @BindsOptionalOf
    abstract fun optionalAccount(): Database.Account
}