package dev.kakueki61

import dev.kakueki61.di.DaggerCommandRouterFactory
import java.util.*

class CommandLineAtm {
    companion object {
        @JvmStatic
        fun main(args : Array<String>) {
            val scanner = Scanner(System.`in`)
            val router = DaggerCommandRouterFactory.create().router()
            while(scanner.hasNextLine()) {
                router.route(scanner.nextLine())
            }
        }
    }
}