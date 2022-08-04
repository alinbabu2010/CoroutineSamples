package coroutines

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
fun main() {

    GlobalScope.launch {
        delay(2000)
        println("World!")
    }

    print("Hello, ")
    Thread.sleep(3000)

}