
interface IPrintType { fun printType() }

// les inline class sont final et n'héritent que des interfaces
inline class GilBag(val coins: Int) : IPrintType {
    override fun printType() {
        println(this.javaClass.name)
    }
    fun canBuyPotion() = coins <= 100
}

fun main() {
    val gilBag = GilBag(42)
    val iPrintTypeHours: IPrintType = gilBag
    println("javaClass from interface: ${iPrintTypeHours.javaClass.name}")
    print("Call method of inline class from interface: ")
    iPrintTypeHours.printType()
}