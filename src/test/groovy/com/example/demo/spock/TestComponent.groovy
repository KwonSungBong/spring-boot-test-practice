package com.example.demo.spock

import java.util.stream.Collectors

/**
 * Created by ksb on 2017. 9. 3..
 */
class TestComponent {

    def test() {
        return "Test"
    }

    def List test1(list) {
        def testList = list.clone()
        int temp

        for(int i = 0; i < testList.size; i++) {
            for(int j = 0; j < testList.size; j++) {
                if(testList[i]<testList[j]) {
                    temp = testList[i]
                    testList[i] = testList[j]
                    testList[j] = temp
                }
            }
        }
        return testList
    }

    def List test2(list) {
        return list.stream().map{it}.sorted{it1,it2 -> Integer.compare(it1,it2)}.collect(Collectors.toList())
    }

    def List test3(list) {
        def testList = list.clone()

        for(int i = 0; i < testList.size; i++) {
            int tempIndex = i
            for(int j = i; j < testList.size; j++) {
                if(testList[tempIndex] < testList[j]) {
                    tempIndex = j
                }
            }
            if(tempIndex != i) {
                int temp = testList[tempIndex]
                testList[tempIndex] = testList[i]
                testList[i] = temp
            }
        }

        return testList
    }

    def List test4(list) {
        def testList = list.clone()
        quickSort(testList, 0, list.size - 1)
        return testList
    }

    def quickSort(list, left, right){
        int l_hold = left
        int r_hold = right
        int pivot = list[left]

        while (left < right) {
            while ((list[right] >= pivot) && (left < right)) {
                right--
            }

            if(left != right) {
                list[left] = list[right]
            }

            while ((list[left] <= pivot) && (left < right)) {
                left++
            }

            if(left != right) {
                list[right] = list[left]
                right--
            }
        }

        list[left] = pivot
        pivot = left
        left = l_hold
        right = r_hold

        if(left < pivot) {
            quickSort(list, left, pivot - 1)
        }
        if(right > pivot) {
            quickSort(list, pivot + 1, right)
        }
    }

    def List test5(list) {
        def testList = list.clone()
        return mergeSort(testList)
    }

    def mergeSort(list) {
        if(list.size<=1) return list

        int mid = list.size % 2 == 0 ? list.size / 2 : (list.size / 2) + 1

        def leftList = list.stream().limit(mid).collect(Collectors.toList())
        def rightList = list.stream().skip(mid).limit(mid).collect(Collectors.toList())

        def L = mergeSort(leftList)
        def R = mergeSort(rightList)

        int i = 0, j = 0
        def result = []

        while(i < L.size && j < R.size) {
            if(L.get(i) < R.get(j)){
                result.add(L.get(i))
                i+=1
            } else {
                result.add(R.get(j))
                j+=1
            }
        }

        result += L.stream().skip(i).collect(Collectors.toList())
        result += R.stream().skip(j).collect(Collectors.toList())
        return result
    }

    def List test6(list) {
        def testList = list.clone()
        return heapSort(testList)
    }

    def heapSort(list) {
        int i, n = list.size-1, temp
        for ( i = (n / 2) ; i >= 1 ; i-- ) // 초기힙만들기
            adjust(list, i, n);
        for ( i = (n - 1) ; i >= 1 ; i-- ) // 힙정렬의두번째단계
        {
            temp = list[i + 1];  // 마지막노드와뿌리노드의교환
            list[i + 1] = list[1];
            list[1] = temp;
            adjust(list, 1, i);  // i개의키에대하여adjust 적용
        }
        return list;
    }

    def adjust(list, i, n) {
        int j, k, done;
        done = 0; // 아직끝나지않았음을표시
        k = list[i]; // 뿌리노드값, 즉옮겨야할원소의값
        j = 2 * i; // i 노드의좌자식노드
        while(( j <= n ) && (!done)) // 자식노드가있고not done 일때까지반복
        {
            if ( j < n )  // j + 1 < = n 과마찬가지로우자식노드의존재를검사
                if (list[j] < list[j+1])
                    j = j + 1;  // 자식노드들중큰노드를선택
            if ( k >= list[j] )
                done = 1; // 자식노드보다크므로수행을중단
            else {
                list[Math.floor(j/2).intValue()] = list[j]; // 자식노드를부모노드로끌어올림
                // 자식노드에k값을쓰지않는이유는나중에
                // 수행이다끝난다음에쓰기때문
                j = 2 * j;
            }
        }
        list[Math.floor(j/2).intValue()] = k; // 수행이끝나면찾아낸위치에맨처음저장한뿌리노드의값을저장
    }
}
