
import org.junit.Assert.assertEquals
import org.junit.Test
import rx.lang.kotlin.fold
import rx.lang.kotlin.observable

class Tests {
    @Test fun firtTest() {
        val sb = StringBuilder()
        observable<String> { subscriber ->
            subscriber.onNext("H")
            subscriber.onNext("e")
            subscriber.onNext("l")
            subscriber.onNext("")
            subscriber.onNext("l")
            subscriber.onNext("o")
            subscriber.onCompleted()
        }.filter { it.isNotEmpty() }
                .fold(sb) { sb, e -> sb.append(e) }
                .map { it.toString() }
                .subscribe { print(it) }
        assertEquals("Hello", sb.toString())
    }
}