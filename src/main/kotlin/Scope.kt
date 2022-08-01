import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun main() {

    println("Execution will now block")

    runBlocking {

        launch {
            delay(1000L)
            println("Task from runBlocking")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task from GlobalScope")
        }

        coroutineScope {
            launch {
                delay(1500L)
                println("Task from CoroutineScope")
            }
        }

    }

    println("Program execution will now continue.")

}