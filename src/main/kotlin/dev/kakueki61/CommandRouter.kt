package dev.kakueki61

import dev.kakueki61.command.Command
import javax.inject.Inject

class CommandRouter @Inject constructor(private val commands: MutableMap<String, Command>) {

    fun route(input: String): Command.Result {
        println("input: $input")
        val splitInput = input.split(' ')
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val result = command.handleInput(splitInput.subList(1, splitInput.size))
        if (result.status == Command.Status.INVALID) {
            println("$commandKey: invalid arguments")
        }
        return result
    }

    private fun invalidCommand(input: String): Command.Result {
        println(
            String.format("couldn't understand \"%s\". please try again.", input)
        )
        return Command.Result(Command.Status.INVALID, null)
    }
}