package dev.kakueki61.di

import dagger.Module
import dagger.Provides
import dev.kakueki61.Outputter

@Module
abstract class SystemOutModule {
    companion object {
        @Provides
        fun textOutputter(): Outputter {
            return object : Outputter {
                override fun output(output: String) {
                    println(output)
                }
            }
        }
    }
}