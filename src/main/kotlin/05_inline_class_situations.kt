
interface IPrintType { fun printType() }

inline class Hours(val i: Int) : IPrintType {
    override fun printType() {
        println(this.javaClass.name)
    }
}

fun asInline(hours: Hours) { hours.printType() }
fun <T> asGeneric(x: T) {
    if(x is Int){
        println("generic Int")
    }else if(x is Hours){
        print("generic Hours - ")
        x.printType()
    }else if(x is IPrintType){
        println("generic IPrintType")
    }
}
fun asInterface(i: IPrintType) { i.printType() }
fun asNullable(i: Hours?) {
    //println(i!!.javaClass.name) //this will cause a crash (look at decompiled code)
    i?.printType()
}

fun <T> id(x: T): T = x

fun main() {
    val hours = Hours(42)
    val iPrintTypeHours: IPrintType = hours
    println("Interface class name: ${iPrintTypeHours.javaClass.name}")
    print("Interface call method of inline class: ")
    iPrintTypeHours.printType()

    print("asInline: ")
    asInline(hours)
    print("asGeneric: ")
    asGeneric(hours)
    print("asInterface: ")
    asInterface(hours)
    print("asNullable: ")
    asNullable(hours)
}