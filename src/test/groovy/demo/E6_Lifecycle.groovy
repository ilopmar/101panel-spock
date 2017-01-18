package demo

import spock.lang.Specification

class E6_Lifecycle extends Specification {

    def setupSpec() {
        println '> setupSpec'
    }

    def setup() {
        println '>> setup'
    }

    def cleanup() {
        println '>> cleanup'
    }

    def cleanupSpec() {
        println '> cleanSpec'
    }

    void 'test'() {
        expect:
            println '>>> test'
    }

    void 'test 2'() {
        expect:
            println '>>> test 2'
    }

    void 'test 3'() {
        expect:
            println '>>> test 3'
    }

}
