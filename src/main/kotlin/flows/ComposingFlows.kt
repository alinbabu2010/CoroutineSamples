package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        zipOperator()
        combineOperator()
    }

}

suspend fun zipOperator() {
    val english = flowOf("One", "Two", "Three")
    val french = flowOf("Un", "Deux", "Troix")
    english.zip(french) { e, f ->
        "'$e' in French is '$f'"
    }.collect {
        println(it)
    }
}

suspend fun combineOperator() {
    val numbers = (1..5).asFlow()
        .onEach { delay(300L) }
    val values = flowOf("One", "Two", "Three", "Four", "Five")
        .onEach { delay(400L) }
    numbers.combine(values) { a, b ->
        "$a -> $b"
    }.collect {
        println(it)
    }
}