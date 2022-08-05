package concurrency

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

@DelicateCoroutinesApi
fun main() {
    runBlocking {
        val coroutineContext = newSingleThreadContext("CounterContext")
        var counter = 0
//        withContext(Dispatchers.Default) {
        massiveRun {
//               withContext(coroutineContext){
            counter++
//                }
        }
//       }
        println("Counter = $counter")
    }
}

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}