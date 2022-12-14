package flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {

        println("Map operator example")
        mapOperator()

        println("\nFilter operator example")
        filterOperator()

        println("\nTransform operator example")
        transformOperator()

        println("\nTake operator example")
        takeOperator()

        println("\nReduce operator example")
        reduceOperator()

        println("\nFlow on operator example")
        flowOnOperator()

    }

}

suspend fun mapOperator() {
    (1..10).asFlow()
        .map {
            delay(500L)
            "Mapping $it"
        }
        .collect {
            println(it)
        }
}

suspend fun filterOperator() {
    (1..10).asFlow()
        .filter {
            it % 2 == 0
        }.collect {
            println(it)
        }
}

suspend fun transformOperator() {
    (1..10).asFlow()
        .transform {
            emit("Emitting string value $it")
            emit(it)
        }
        .collect {
            println(it)
        }
}

suspend fun takeOperator() {
    (1..10).asFlow()
        .take(2)
        .collect {
            println(it)
        }
}

suspend fun reduceOperator() {
    val size = 10
    val factorial = (1..size).asFlow()
        .reduce { accumulator, value ->
            accumulator * value
        }
    println("Factorial of $size is $factorial")
}

suspend fun flowOnOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }

}