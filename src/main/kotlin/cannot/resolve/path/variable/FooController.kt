package cannot.resolve.path.variable

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

private const val CONTRACT = "contract"

private val LOGGER = KotlinLogging.logger { }

@RestController
class FooController {
    
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/$CONTRACT/{agreementId}")
    internal fun delete(@PathVariable agreementId: String) {
        LOGGER.info { "Hello World!" }
    }

}
