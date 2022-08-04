package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {

    val numbersFlow = sendNewNumbers()
    val numbFlow = sendNumbs()
    println("Flow hasn't started yet")
    println("Starting flow now")

    runBlocking {
        numbersFlow.collect {
            println(it)
        }
        withTimeoutOrNull(1000L) {
            numbFlow.collect {
                println(it)
            }
        }
    }
}

private fun sendNewNumbers() = listOf(1, 2, 3).asFlow()

private fun sendNumbs() = flow {
    listOf(1, 2, 3, 4, 5, 6).forEach {
        delay(400L)
        emit(it)
    }
}