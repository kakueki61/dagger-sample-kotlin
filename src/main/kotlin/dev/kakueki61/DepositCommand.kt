package dev.kakueki61

import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(private val db: Database, private val outputter: Outputter) : Command {
    init {
        println("Creating a new $this")
    }

    override fun handleInput(input: List<String>): Command.Status {
        if (input.size != 2) {
            return Command.Status.INVALID
        }

        val account = db.getAccount(input.first())
        account.deposit(BigDecimal(input[1]))
        outputter.output("${account.userName} now has: ${account.balance}")
        return Command.Status.HANDLED
    }
}