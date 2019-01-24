// DataMail est un wrapper. Il encapsule un type existant pour ajouter du comportement et un niveau d'abstraction supplémentaire

data class Mail(val mail:String) {
    fun isValid() = mail.contains("@")
    fun dns() = if(isValid()) mail.substringAfter("@") else ""
}

fun main() {
    val mail = Mail("ilove@apple.com")
    println("type: ${mail.javaClass.name} ${mail.mail}, valid ${mail.isValid()}, dns ${mail.dns()}")
}
