package doublr.digitall.locationinflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

@SpringBootApplication
class LocationInfluxApplication

fun main(args: Array<String>) {
    runApplication<LocationInfluxApplication>(*args)
}

@RestController
class RestController {

    @GetMapping(value = ["/influx/{symbol}"],
    produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun influxFor(@PathVariable symbol: String): Flux<LocationInflux> {
        return Flux.interval(Duration.ofSeconds(1))
            .map { LocationInflux(symbol, generateRandomCount(), LocalDateTime.now()) }
    }

    private fun generateRandomCount(): Int = ThreadLocalRandom.current().nextInt(100)
}

data class LocationInflux(val symbol: String, val count: Int, val time: LocalDateTime)