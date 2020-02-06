package dev.kakueki61

class LoginCommand(private val outputter: Outputter) : SingleArgCommand() {
    override fun key(): String {
       return "login"
    }

    override fun handleArg(userName: String): Command.Status {
        println("$userName is logged in.")
        return Command.Status.HANDLED
    }
}