package com.example.demo.spock

import org.junit.Test

/**
 * Created by ksb on 2017. 9. 3..
 */
class TestComponentTests {

    private TestComponent testComponent = new TestComponent()

    @Test
    void 테스트() {
        def test = testComponent.test()
        println test
    }

    @Test
    void 테스트1() {
        def list = [1,10,8,9,6,7,5,4,3,2]
        def testList = testComponent.test1(list)
        testList.each{ println "$it" }
        assert testList == [1,2,3,4,5,6,7,8,9,10]
    }

    @Test
    void 테스트2() {
        def list = [1,10,8,9,6,7,5,4,3,2]
        def testList = testComponent.test2(list)
        testList.each{ println "$it" }
        assert testList == [1,2,3,4,5,6,7,8,9,10]
    }

    @Test
    void 테스트3() {
        def list = [1,10,8,9,6,7,5,4,3,2]
        def testList = testComponent.test3(list)
        testList.each{ println "$it" }
        assert testList == [10,9,8,7,6,5,4,3,2,1]
    }

    @Test
    void 테스트4() {
        def list = [1,10,8,9,6,7,5,4,3,2]
        def testList = testComponent.test4(list)
        testList.each{ println "$it" }
        assert testList == [1,2,3,4,5,6,7,8,9,10]
    }

    @Test
    void 테스트5() {
        def list = [10,1,8,9,6,7,5,4,3,2]
        def testList = testComponent.test5(list)
        testList.each{ println "$it" }
        assert testList == [1,2,3,4,5,6,7,8,9,10]
    }

    @Test
    void 테스트6() {
        def list = [1,10,8,9,6,7,5,4,3,2]
        def testList = testComponent.test6(list)
        testList.each{ println "$it" }
        assert testList == [1,2,3,4,5,6,7,8,9,10]
    }

}
