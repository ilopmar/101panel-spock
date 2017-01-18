package demo

import static E12_Requires_IgnoreIf.isAmazingConference

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification
import spock.util.environment.Jvm
import spock.util.environment.OperatingSystem

class E12_Requires_IgnoreIf extends Specification {

    @Requires({ OperatingSystem.current.linux })
    void 'should only run on Linux'() {
        expect:
            true
    }

    @Requires({ OperatingSystem.current.windows })
    void 'should only run on Windows'() {
        expect:
            false
    }

    @IgnoreIf({ Jvm.current.java8Compatible })
    void 'should be ignored in Java8+'() {
        expect:
            false
    }

    @IgnoreIf({ Jvm.current.java9 })
    void 'should be ignored only in Java9'() {
        expect:
            true
    }

    @Requires({ isAmazingConference('Greach')})
    void 'should run for amazing conferences'() {
        expect:
            true
    }

    static boolean isAmazingConference(String conference) {
        conference in ['Greach', 'GR8Conf']
    }

}
