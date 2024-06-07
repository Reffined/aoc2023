package reffined

fun loadResource(path: String): ByteArray? {
    object {}::class.java.getResource(path)?.readBytes().apply {
        return this
    }
}