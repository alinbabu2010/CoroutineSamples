import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            print("This run from ${coroutineContext[CoroutineName.Key]}")
        }
    }
}