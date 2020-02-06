package dev.kakueki61.di

import dagger.Binds
import dagger.Module
import dev.kakueki61.Command
import dev.kakueki61.LoginCommand

@Module
abstract class LoginCommandModule {
    @Binds
    abstract fun loginCommand(loginCommand: LoginCommand): Command
}