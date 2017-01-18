package demo

import spock.lang.Specification

class E1_Basic extends Specification {

    void 'should reverse a string'() {
        given: 'a string'
            def myString = 'Hello World!'

        when: 'reversing it'
            def reversed = myString.reverse()

        then: 'it is reversed'
            reversed == '!dlroW olleH'
    }

    void 'should reverse a string (II)'() {
        expect:
            'Hello World!'.reverse() == '!dlroW olleH'
    }

}
