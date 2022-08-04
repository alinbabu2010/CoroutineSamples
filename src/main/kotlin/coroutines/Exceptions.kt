package coroutines

import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun main() {

    runBlocking {

        val myHandler = CoroutineExceptionHandler { _, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from job")
            throw IndexOutOfBoundsException("Exception in coroutine")
        }

        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("exception form async")
        }

        try {
            deferred.await()
        } catch (e: ArithmeticException) {
            println("Caught ArithmeticException ${e.localizedMessage}")
        }

    }

}