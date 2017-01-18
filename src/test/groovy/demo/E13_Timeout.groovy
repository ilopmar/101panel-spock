package demo

import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

class E13_Timeout extends Specification {

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void 'should fail after 500 milliseconds'() {
        given:
            Thread.sleep 500

        expect:
            true
    }
}
