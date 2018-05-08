package com.example.demo.spock

import spock.lang.Specification

/**
 * Created by whilemouse on 17. 8. 30.
 */
class SpockPracticeTest extends Specification {

    private TestComponent testComponent = new TestComponent()

    def "테스트"() {

        when:
        def test = testComponent.test()

        then:
        test == "Test"
    }

    def "테스트1"() {
        given:
        def list = [1,10,8,9,6,7,5,4,3,2]

        when:
        def testList = testComponent.test1(list)

        then:
        testList == [1,2,3,4,5,6,7,8,9,10]
        testList.size == 10
    }

    def "테스트2"() {
        given:
        def list = [1,10,8,9,6,7,5,4,3,2]

        when:
        def testList = testComponent.test2(list)

        then:
        testList == [1,2,3,4,5,6,7,8,9,10]
        testList.size == 10
    }

}
