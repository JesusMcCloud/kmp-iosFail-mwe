package parent

import Bar
import io.matthewnelson.encoding.base64.Base64
import io.matthewnelson.encoding.core.Encoder.Companion.encodeToString

val fibi = sequence {
    val bar = Bar("foobar").serialize()
    println(bar.encodeToString(Base64.Default))
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

expect val firstElement: Int
expect val secondElement: Int
