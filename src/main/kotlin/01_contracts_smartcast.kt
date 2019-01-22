import org.jetbrains.annotations.Contract
import java.lang.IllegalArgumentException
import kotlin.contracts.ContractBuilder
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun checkNotNull(s: String?) = s != null

@ExperimentalContracts
fun checkNotNullWithContracts(s: String?):Boolean {
    contract {
        // booleanExpression can accept only a subset of boolean expressions
        returns(true) implies(s != null)
    }
    return s != null
}

@ExperimentalContracts
fun myRequire(condition: Boolean) {
    contract {
        returns() implies condition
    }

    if(condition == false) throw IllegalArgumentException()
}

@ExperimentalContracts
fun main(){
    var s: String?

    s = readLine()

    if(s == "null") s = null

    // Compiler automatically casts 's' to 'String'
    if (s != null)  print(s.length)

    //Not handeled by smartcast
    //if (checkNotNull(s)) print(s.length)

    if(checkNotNullWithContracts(s)) print(s.length)

    myRequire(s is String)
    //s smart casted because the app returns only if condition is true
    print(s.length)
}



