package com.example.demo

import spock.lang.Specification

class TestTestTest extends Specification {

    def "테스트1"() {
        def result = []

        result << [1,2,3,4]
        result << [1,2,3,4,5]
//        result >> [2,3,4,5]

        def plus2  = { it + 2 }
        def times3 = { it * 3 }

        def times3plus2 = plus2 << times3
        assert times3plus2(3) == 11
        assert times3plus2(4) == plus2(times3(4))

        def plus2times3 = times3 << plus2
        assert plus2times3(3) == 15
        assert plus2times3(5) == times3(plus2(5))

        assert times3plus2(3) == (times3 >> plus2)(3)

        when:
        def test = "Test"

        then:
        test == "Test"
    }

    def "테스트2"() {
        Integer x = 123
        String s = x as String

        when:
        def test = "Test"

        then:
        test == "Test"
    }

    def "TEST3"() {
        def test1 = "test1"

        when:
        def test2 = "test2"

        then:
        test1 != test2
    }

    def "TEST4"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        3 | 9 | 9
    }

}
