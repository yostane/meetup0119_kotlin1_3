inline class InlineMinutes(val minutes:Int)
typealias TypealiasMinutes = Int

fun main(){
    var tam:TypealiasMinutes = 10
    var i:Int = 10
    tam = i
    // var im: InlineMinutes = 10 //not possible
    // var im2: InlineMinutes = tam //not possible
    var im3: InlineMinutes = InlineMinutes(10)
    //tam = im3 //not possible
    // im3 = i //not possible
}