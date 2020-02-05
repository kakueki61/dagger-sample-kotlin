package dev.kakueki61

import javax.inject.Inject

class HelloWorldCommand @Inject constructor() : Command {
    override fun key(): String {
        return "hello"
    }

    override fun handleInput(input: List<String>): Command.Status {
        if (input.isNotEmpty()) {
            return Command.Status.INVALID
        }
        println("world!")
        return Command.Status.HANDLED
    }
}