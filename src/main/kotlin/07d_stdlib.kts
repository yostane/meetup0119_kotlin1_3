
//associateWith crée un dictionnaire plus succintement que la méthode associate
val alphabet = 'a'..'z'
fun decryptCesar(c: Char, shift: Int = 3): Char {
    val decoded = c - shift
    return if(decoded >= 'a') decoded else decoded + ('z' - 'a' + 1)
}

// Avec associate
val associateMap = alphabet.associate { it to decryptCesar(it) }
println(associateMap.toString())