import io.reactivex.netty.protocol.http.client.HttpClient
import org.junit.Test
import org.slf4j.LoggerFactory
import java.nio.charset.Charset

class FirstRxNettyTest {

    val logger = LoggerFactory.getLogger(FirstRxNettyTest::class.java)!!

    @Test fun firstSimpleTest() {
        val response = StringBuilder()
                HttpClient
                .newClient("search.maven.org", 80)
                .createGet("/solrsearch/select?wt=json&q=spring")
                .flatMap { resp -> resp.content.map { bb -> bb.toString(Charset.defaultCharset()) } }
                .toBlocking()
                .forEach {
                    response.append(it)
                }
        logger.debug(response.toString())
    }
}