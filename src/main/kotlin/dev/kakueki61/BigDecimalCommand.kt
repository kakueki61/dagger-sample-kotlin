package dev.kakueki61

import java.lang.NumberFormatException
import java.math.BigDecimal

abstract class BigDecimalCommand(private val outputter: Outputter) : SingleArgCommand() {
    override fun handleArg(arg: String): Command.Result {
        val amount = tryParse(arg)

        when {
            amount == null -> outputter.output("$arg is not a valid number.")
            amount.signum() <= 0 -> outputter.output("amount must be positive.")
            else -> handleAmount(amount)
        }
        return Command.Result.handled()
    }

    /** Handles the given (positive) [amount] of money. */
    abstract fun handleAmount(amount: BigDecimal)

    companion object {
        fun tryParse(arg: String): BigDecimal? {
            return try {
                BigDecimal(arg)
            } catch (e: NumberFormatException) {
                null
            }
        }
    }
}