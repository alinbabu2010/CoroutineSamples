package channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

fun main() {

    runBlocking {
        val producer = produceNumbers()
        repeat(5) {
            launchProcessor(it, producer)
        }
        delay(1000L)
        producer.cancel()
    }

}

@OptIn(ExperimentalCoroutinesApi::class)
private fun CoroutineScope.produceNumbers() = produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100L)
    }
}

private fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel)
        println("Processor $id in received $msg")
}