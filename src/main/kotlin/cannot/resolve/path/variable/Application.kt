package cannot.resolve.path.variable

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main() {
    runApplication<Application>()
}

