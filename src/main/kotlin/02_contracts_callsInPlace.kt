import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun executeOnceWithoutContracts(functionToRun: () -> Unit) {
    functionToRun()
}

//does not compile
/*
fun startGameV1(): Int {
    val lives: Int
    executeOnceWithoutContracts {
        lives = 5
    }
    // Compile error here
    return lives
}*/

@ExperimentalContracts
//use inline for kotlin < 1.3.20 (it is a workaround)
inline fun executeOnce(functionToRun: () -> Unit) {
    contract {
        callsInPlace(functionToRun, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    functionToRun()
}

//Code is ok buy may generate exception during compilation.

@ExperimentalContracts
fun startGameV2(): Int {
   val lives: Int
   executeOnce {
       lives = 5
   }
   // no compile error!
   return lives
}

@ExperimentalContracts
fun main() {
   val lives = startGameV2()
    println("Thou have $lives")
}