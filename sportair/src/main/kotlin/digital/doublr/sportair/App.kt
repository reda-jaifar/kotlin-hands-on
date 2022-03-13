package digital.doublr.sportair

fun exerciseOutside(temperature: Int): String {
    return if (temperature in 11..28) {
        "of course"
    } else {
        "nope"
    }
}
fun main(args: Array<String>) {
    println("${"can I exercise outside when temperature is "}${args[0]} celsius? ${exerciseOutside(args[0].toInt())}")
}