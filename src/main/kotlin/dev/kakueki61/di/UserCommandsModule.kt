package dev.kakueki61.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import dev.kakueki61.Command
import dev.kakueki61.DepositCommand

@Module
abstract class UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(command: DepositCommand): Command
}