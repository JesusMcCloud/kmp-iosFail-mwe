package parent
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class JvmFibiTest : FreeSpec({
    "test 3rd element" {
        fibi.take(3).last() shouldBe 5
    }
})