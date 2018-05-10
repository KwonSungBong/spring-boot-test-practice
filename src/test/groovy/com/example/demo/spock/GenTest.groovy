package com.example.demo.spock

import spock.genesis.Gen
import spock.lang.Specification

class GenTest extends Specification {

    def "test reverse #string"() {
        when:
        def reversed = string.reverse()

        then:
        reversed.size() == string.size()
        if (string) {
            string.eachWithIndex {
                letter, i ->
                    letter == reversed[-(i + 1)]
            }
        }
        reversed.reverse() == string

        where:
        string << Gen.these('', 'foo').then(Gen.string).take(10000)
    }

}
