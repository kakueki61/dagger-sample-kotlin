package dev.kakueki61

import javax.inject.Inject

class HelloWorldCommand @Inject constructor(private val outputter: Outputter) : Command {
    override fun key(): String {
        return "hello"
    }

    override fun handleInput(input: List<String>): Command.Status {
        if (input.isNotEmpty()) {
            return Command.Status.INVALID
        }
        outputter.output("world!")
        return Command.Status.HANDLED
    }
}