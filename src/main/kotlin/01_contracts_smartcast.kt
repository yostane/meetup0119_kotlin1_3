
fun main(){
    var s: String?
    s = readLine()
    if(s == "windows phone") s = null

    // Compiler automatically casts 's' to 'String'
    if (s != null)  print(s.length)
}



