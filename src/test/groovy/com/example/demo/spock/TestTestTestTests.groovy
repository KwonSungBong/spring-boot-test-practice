package com.example.demo.spock

import org.junit.After
import org.junit.Before
import org.junit.Test

class TestTestTestTests {

	@After
	void after() {
		println "after"
	}

	@Before
	void before() {
		println "before"
	}

	@Test
	void contextLoads() {
	}

	@Test
	void 테스트() {
		println 1
		println 2
		println 3
		["a", "b", "c"].findAll{it.size() <= 4}.each{println it}
		println 4
		println 5
	}

	@Test
	void listTest() {
		def a = []
		a += [1,2,3]
		assert a == [1,2,3]
		assert a[0] == 1
		assert a.get(0) == 1
		assert a.getAt(0) == 1

		a << 4 << 5
		assert a == [1,2,3,4,5]

		a.add(6)
		assert a == [1,2,3,4,5,6]

		a.putAt(1,1)
		assert a == [1,1,3,4,5,6]
		assert a.set(1,2) == 1
		assert a == [1,2,3,4,5,6]

		a.each {println "$it"}
		a.eachWithIndex { it, index -> println item : "$it", index : "$index" }

		a -= 1
		assert a == [2,3,4,5,6]
		a = a.minus([2,3,4])
		assert a == [5,6]
	}

	@Test
	void mapTest() {
		def map = ['name': 'Bashar', 'age':26, skills:['Java', 'Groovy'], 'author':true]
		assert map.size() == 4

		map += ['city': 'Tucson']
		assert map == ['name':'Bashar', 'age':26, skills:['Java','Groovy'], 'author':true, city:'Tucson']

		map['state'] = 'AZ'
		assert map == ['name':'Bashar', 'age':26, skills:['Java','Groovy'], 'author':true, city:'Tucson', 'state':'AZ']

		assert map.city == 'Tucson'
		assert map['city'] == 'Tucson'
		assert map.get('city') == 'Tucson'
		assert map.getAt('city') == 'Tucson'
		assert map.skills[0] == 'Java'

		assert ['name':'Bashar', 'name':'Abdul'] == ['name':'Abdul']

		map.each { it -> println it.key + ":" + it.value }
		map.eachWithIndex { it, index -> println "item $index - " + it.key + ":" + it.value }
	}

	@Test
	void rangeTest() {
		def range = 1..10
		assert range == [1,2,3,4,5,6,7,8,9,10]

		range = 'a'..'c'
		assert range == ['a', 'b', 'c']

		range = 1..<8
		assert range == [1,2,3,4,5,6,7]

		(1..5).each{println it}

		assert[*1..4] == [1,2,3,4]
		assert[1, *2..4] == [1,2,3,4]
	}



}
