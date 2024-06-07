package reffined


fun main() {
    object {}::class.java.getResource("/1.txt")?.readText().apply {
        println(this)
    }
}

