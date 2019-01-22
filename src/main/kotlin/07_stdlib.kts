import kotlin.random.Random

// Multiplatform random
// number is in range [0, limit)
val number = Random.nextInt(42)
println(number)

// isNullOrEmpty/orEmpty extensions on collections, maps, and arrays of objects
val collection: MutableCollection<Int>? = null
collection.isNullOrEmpty()
// returns empty list if null
collection.orEmpty()

// array.copyInto(targetArray, targetOffset, startIndex, endIndex)
val sourceArr = arrayOf("la", "si", "ré", "sol", "fa", "si")
val targetArr = sourceArr.copyInto(arrayOfNulls<String>(6), startIndex = 3, endIndex = 6)
targetArr.contentToString()
sourceArr.copyInto(targetArr, 3, 0, 3)
"Les musiciens aiments les maison avec un: "
targetArr.contentToString()

//associateWith easier than associate to create a map
val keys = 1..5
fun getValue(i: Int) = if(i%2 == 0) "even" else "odd"
val previousMap = keys.associate { it to getValue(it) }
previousMap.toString()
val map = keys.associateWith { getValue(it) }
map.toString()

// ifEmpty for Collections, maps, object arrays, char sequences, and sequences
fun testIfEmpty (list: List<String>) = list.filter{ it.toUpperCase() == it }.ifEmpty { "No upper case" }
// testIfEmpty if of type any
testIfEmpty(listOf("foo", "bar"))
testIfEmpty(listOf("FOO", "bar"))
// ifBlank for strings and char sequences
"  \t \r  \n".ifBlank { "I am empty :/" }
"a \t \r  \n".ifBlank { "I am empty :/" }
