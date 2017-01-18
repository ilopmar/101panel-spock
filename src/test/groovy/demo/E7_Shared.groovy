package demo

import spock.lang.Shared
import spock.lang.Specification

class E7_Shared extends Specification {

    @Shared
    def user = new User('Iván', 'López')

    void 'should print user'() {
        expect:
            println user
    }

    void 'should print user again'() {
        expect:
            println user
    }

}
