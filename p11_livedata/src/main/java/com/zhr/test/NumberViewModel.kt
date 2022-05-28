package com.zhr.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Des:
 *
 * @Title:
 * @Project: LongWayTest
 * @Package: com.zhr.test
 * @Author: zhr
 * @Date: 2022/5/22 20:49
 * @Version: V1.0
 */
class NumberViewModel : ViewModel() {

    val num by lazy {
        MutableLiveData<Int>()
    }

    fun add1(){
        num.postValue(num.value?.plus(1))
    }

    fun reduce1(){
        num.postValue(num.value?.minus(1))
    }
}