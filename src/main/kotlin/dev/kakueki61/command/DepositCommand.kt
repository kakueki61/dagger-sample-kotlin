package dev.kakueki61.command

import dev.kakueki61.Database
import dev.kakueki61.Outputter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand
@Inject
constructor(
    private val account: Database.Account,
    private val outputter: Outputter
) : BigDecimalCommand(outputter) {
    init {
        println("Creating a new $this")
    }

    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        outputter.output("${account.userName} now has: ${account.balance}")
    }
}