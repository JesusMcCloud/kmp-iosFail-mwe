import kotlinx.serialization.Serializable
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.cbor.CborLabel
import kotlinx.serialization.encodeToByteArray

val fibi = sequence {
    var a = firstElement
    yield(a)
    var b = secondElement
    yield(b)
    while (true) {
        val c = a + b
        yield(c)
        a = b
        b = c
    }
}

val firstElement: Int = 2
val secondElement: Int = 3


@Serializable
data class Bar(@CborLabel(348L) val foo: String = "baz") {
    fun serialize(): ByteArray = Cbor.encodeToByteArray(this)
}