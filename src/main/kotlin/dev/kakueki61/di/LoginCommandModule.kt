package dev.kakueki61.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import dev.kakueki61.Command
import dev.kakueki61.HelloWorldCommand
import dev.kakueki61.LoginCommand

@Module
abstract class LoginCommandModule {
    @Binds @IntoMap
    @StringKey("login")
    abstract fun loginCommand(loginCommand: LoginCommand): Command
}