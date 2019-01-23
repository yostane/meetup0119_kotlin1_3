
fun main(){
    var s: String?
    s = readLine()
    if(s == "null") s = null

    // Compiler automatically casts 's' to 'String'
    if (s != null)  print(s.length)
}



