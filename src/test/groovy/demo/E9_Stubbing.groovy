package demo

import spock.lang.Specification

class E9_Stubbing extends Specification {

    void 'should return predefined value'() {
        given:
            def stubbedRepository = Stub(UserRepository) {
                findById(_) >> new User('John', 'Doe')
            }

        when:
            def user = stubbedRepository.findById(1)

        then:
            user.name == 'John'
            user.lastName == 'Doe'
    }

    void 'should return different values in every call'() {
        given:
            def stubbedRepository = Stub(UserRepository) {
                findById(_) >>> [
                    new User('John', 'Doe'),
                    new User('Jane', 'Doe')
                ]
            }

        when:
            def user1 = stubbedRepository.findById(1)
            def user2 = stubbedRepository.findById(1)
            def user3 = stubbedRepository.findById(1)

        then:
            user1.name == 'John'
            user2.name == 'Jane'
            user3.name == 'Jane'
    }

    void 'should return values depending the parameters'() {
        given:
            def stubbedRepository = Stub(UserRepository) {
                findById(20) >> new User('Jane', 'Doe')
                findById(11) >> new User('John', 'Doe')
            }

        when:
            def user1 = stubbedRepository.findById(11)
            def user2 = stubbedRepository.findById(20)

        then:
            user1.name == 'John'
            user2.name == 'Jane'
    }

    void 'should throw an exception'() {
        given:
            def stubbedRepository = Stub(UserRepository) {
                findById(_) >> { throw new RuntimeException("User does not exist") }
            }

        when:
            stubbedRepository.findById(1)

        then:
            def e = thrown RuntimeException
            e.message == 'User does not exist'
    }

    void 'should stub more than one method'() {
        given:
            def stubbedRepository = Stub(UserRepository) {
                findById(_) >> new User('Peter', 'Smith')
                findAllByLastName('Doe') >> [
                    new User('John', 'Doe'),
                    new User('Jane', 'Doe')
                ]
            }

        expect:
            stubbedRepository.findById(99).name == 'Peter'
            stubbedRepository.findAllByLastName('Doe').size() == 2
    }

}
