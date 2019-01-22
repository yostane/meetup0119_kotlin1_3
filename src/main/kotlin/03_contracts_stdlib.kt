fun main(){

    var s: String? = null

    s = readLine()
    if(s == "null") s = null

    //isNullOrEmpty uses returns contract for smarcasting
    if( ! s.isNullOrEmpty() ){
        println("s is not null. Length ${s.length}")
    }else{
        println("s is null")
    }
    //require uses returns contact on the condition
    require(s is String)
    println("s is a String. Length: ${s.length}")

    val lock = "lock"
    val message: String
    //callsInPlaceContract once for the block
    synchronized(lock) {
        message = "initialized"
    }
    println("message $message")
}