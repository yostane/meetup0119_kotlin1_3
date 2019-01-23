// In kotlin, we can definc static members and functions using a companion object
interface OldKotlinCar {
    companion object {
        val nbWheels = 4
        fun makeNoise() = "VROOM VROOM"
    }
}