package flows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {

        println("Try-catch exception handling")
        tryCatch()

        println("\nCatch operator exception handling")
        catch()

        println("\nonCompletion example - equivalent to finally block ")
        onCompletion()

    }

}

suspend fun tryCatch() {
    try {
        (1..3).asFlow()
            .onEach { check(it != 2) }
            .collect { println(it) }
    } catch (exception: Exception) {
        println("Caught Exception : $exception")
    }
}

suspend fun catch() {
    (1..3).asFlow()
        .onEach { check(it != 2) }
        .catch { e -> println("Caught Exception : $e") }
        .collect { println(it) }
}

suspend fun onCompletion() {
    (1..3).asFlow()
        .onEach { check(it != 2) }
        .onCompletion { e ->
            if (e != null) println("Flow completed with exception $e")
            else println("Flow completed successfully")
        }
        .catch { e -> println("Caught Exception : $e") }
        .collect { println(it) }
}