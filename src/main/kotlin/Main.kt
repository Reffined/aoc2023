package reffined

import java.nio.charset.Charset


fun main() {
    val file =
        loadResource("/1.txt")?.toString(Charset.defaultCharset()) ?: throw NullPointerException("couldn't read file")
    var sum = 0

    file.split("\n").map {
        it.replace(Regex("\\D"), "").toCharArray().apply {
            val num = "${first()}${last()}"
            sum += num.toInt()
            println(sum)
        }
    }
    println(sum)

}

