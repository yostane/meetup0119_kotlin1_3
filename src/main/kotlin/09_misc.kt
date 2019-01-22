// In kotlin, we can definc static members and functions using a companion object
interface OldKotlinCar {
    companion object {
        val nbWheels = 4
        fun makeNoise() = "VROOM VROOM"
    }
}

// Kotlin 1.3 introdices @JvmField and @JvmStatic annotations that makes static fields directly
// accessible from both java and kotlin
interface Car {
    companion object {
        @JvmField
        val nbWheels = 4

        @JvmStatic
        fun makeNoise() = "VROOM VROOM"
    }
}

interface Foo {
    // Will be generated as 'default' method
    @JvmDefault
    fun foo(): Int = 42
}

// Propagated experimental
@UseExperimental(ExperimentalUnsignedTypes::class)
fun experimentUnsigned() {
    // kotlin.UInt: an unsigned 32-bit integer, ranges from 0 to 2^32 - 1
    val uint = 42u
    // kotlin.ULong: an unsigned 64-bit integer, ranges from 0 to 2^64 - 1
    val ulong = 42uL
    // kotlin.UByte: an unsigned 8-bit integer, ranges from 0 to 255
    val ubyte: UByte = 255u
    // kotlin.UShort: an unsigned 16-bit integer, ranges from 0 to 65535
    val uShort = uint.toUShort()

    // Conversion via stdlib extensions
    val int = uint.toInt()
    val byte = ubyte.toByte()
    val ulong2 = byte.toULong()

    // Unsigned types support similar operators:
    val x = 20u + 22u
    val y = 1u shl 8
    val z = "128".toUByte()
    val range = 1u..5u

    println("unsigned $uint, $ulong $ubyte")
}

fun main() {

    experimentUnsigned()

    OldKotlinCar.nbWheels
    OldKotlinCar.makeNoise()
}