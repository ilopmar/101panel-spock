package demo

import spock.lang.Specification

class E8_Mocking extends Specification {

    void 'should send a notification when the someone registers'() {
        given:
            def mockedNotificationService = Mock(NotificationService)
            def userService = new UserService(mockedNotificationService)

        when:
            userService.createUser('Iván', 'López')

        then:
            1 * mockedNotificationService.sendNotification(_, 'User created')
    }

    void 'should check constraints on interactions'() {
        given:
            def mockedNotificationService = Mock(NotificationService)
            def userService = new UserService(mockedNotificationService)

        when:
            userService.createUser('Iván', 'López')

        then:
            1 * mockedNotificationService.sendNotification({it.name == 'Iván'}, 'User created')
    }

    void 'should mock an implementation'() {
        given:
            def user = new User('Iván', 'López')
            def mockedEmailService = Mock(EmailService)

        when:
            mockedEmailService.sendEmail(user, 'How are you?')

        then:
            1 * mockedEmailService.sendEmail(user, 'How are you?')
    }

    void 'should check the order'() {
        given:
            def user = new User('Iván', 'López')
            def mockedNotificationService = Mock(NotificationService)

        when:
            mockedNotificationService.sendNotification(user, 'msg1')
            mockedNotificationService.sendNotification(user, 'msg2')
            mockedNotificationService.sendNotification(user, 'msg3')

        then:
            1 * mockedNotificationService.sendNotification(user, 'msg1')

        then:
            1 * mockedNotificationService.sendNotification(user, 'msg2')

        then:
            1 * mockedNotificationService.sendNotification(user, 'msg3')
    }

}
