package dev.kakueki61.command

/**
 * Logic to process some user input
 */
abstract class SingleArgCommand : Command {
    override fun handleInput(input: List<String>): Command.Result {
        return if(input.size == 1) handleArg(input.first()) else Command.Result(
            Command.Status.INVALID, null)
    }

    abstract fun handleArg(arg: String): Command.Result
}