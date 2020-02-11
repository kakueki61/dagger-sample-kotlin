package dev.kakueki61.di

import dagger.Module
import dagger.Provides
import dev.kakueki61.di.qualifier.MaximumWithdrawal
import dev.kakueki61.di.qualifier.MinimumBalance
import java.math.BigDecimal

@Module
interface AmountsModule {
    companion object {
        @Provides
        @MinimumBalance
        fun minimumBalance() = BigDecimal.ZERO

        @Provides
        @MaximumWithdrawal
        fun maximumWithdrawal() = 1000.toBigDecimal()
    }
}