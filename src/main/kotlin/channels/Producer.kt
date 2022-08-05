package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
fun main() {
    runBlocking {

/*        val channel = produce {
            for (x in 1..5)
                send(x * x)
        }
        for (y in channel)
            println(y)
*/
        /*
        for (y in produceSquares())
            println(y)
         */

        produceSquares().consumeEach {
            println(it)
        }
    }
}

@ExperimentalCoroutinesApi
private fun CoroutineScope.produceSquares() = produce {
    for (x in 1..5)
        send(x * x)
}