data class DataMail(val mail:String) {
    fun isValid() = mail.contains("@")
    fun dns() = if(isValid()) mail.substringAfter("@") else ""
}

inline class InlineMail(val mail:String) {
    fun isValid() = mail.contains("@")
    fun dns() = if(isValid()) mail.substringAfter("@") else ""
}

fun main() {
    val dataMail = DataMail("toto-gmail.com")
    println("type: ${dataMail.javaClass.name} ${dataMail.mail}, valid ${dataMail.isValid()}, dns ${dataMail.dns()}")
    val inlineMail = InlineMail("toto@gmail.com")
    println("type: ${inlineMail.javaClass.name} value: ${inlineMail.mail}, valid ${inlineMail.isValid()}, dns ${inlineMail.dns()}")
}
