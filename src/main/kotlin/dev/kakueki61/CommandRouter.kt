package dev.kakueki61

import javax.inject.Inject

class CommandRouter @Inject constructor(command: Command) {

    private val commands = mutableMapOf<String, Command>()

    init {
        commands[command.key()] = command
    }

    fun route(input: String): Command.Status {
        println("input: $input")
        val splitInput = input.split(' ')
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val status = command.handleInput(splitInput.subList(1, splitInput.size))
        if (status == Command.Status.INVALID) {
            println("$commandKey: invalid arguments")
        }
        return status
    }

    private fun invalidCommand(input: String): Command.Status {
        println(
            String.format("couldn't understand \"%s\". please try again.", input)
        )
        return Command.Status.INVALID
    }
}