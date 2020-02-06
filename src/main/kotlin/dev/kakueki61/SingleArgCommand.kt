package dev.kakueki61

/**
 * Logic to process some user input
 */
abstract class SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Command.Status {
        return if(input.size == 1) handleArg(input.first()) else Command.Status.INVALID
    }

    abstract fun handleArg(arg: String): Command.Status
}