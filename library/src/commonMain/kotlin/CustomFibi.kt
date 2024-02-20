package parent

import Bar

val fibi = sequence {
    val bar = Bar("foobar")
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
