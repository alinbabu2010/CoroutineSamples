package flows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        println("Flow creation example")
        sendNumbers().collect {
            println("Received $it")
        }

        println("List as flow example")
        listOfNumbers.collect {
            println("Received $it")
        }

        println("flowOf example")
        flowOfNumbers.collect {
            println("Received $it")
        }

    }
}

fun sendNumbers() = flow {
    for (i in 1..10) emit(i)
}

val listOfNumbers = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20).asFlow()

val flowOfNumbers = flowOf("One", "Two", "Three")