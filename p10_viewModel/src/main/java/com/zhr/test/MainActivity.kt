package com.zhr.test

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mViewModel: NumberViewModel? = null
    private lateinit var textView: TextView
    private lateinit var add: Button
    private lateinit var reduce: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 创建一个ViewModel的对象
        // 这种创建方法 目前已经过时了
//        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        // 目前这种创建ViewModel的方法是主流
        mViewModel = ViewModelProvider(this).get(NumberViewModel::class.java)
        initView()
        // 给textView设置初始值
        textView.text = mViewModel?.number.toString()
    }

    private fun initView() {
        textView = findViewById(R.id.tv)
        add = findViewById(R.id.add)
        reduce = findViewById(R.id.reduce)
        add.setOnClickListener(this)
        reduce.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            // viewModel能够临时保存变量数据，不受activity生命周期的影响。比如修改屏幕状态时值不会丢失掉
            R.id.add -> {
                mViewModel?.number = mViewModel?.number?.plus(1)!!
                textView.text = mViewModel?.number.toString()
            }
            R.id.reduce -> {
                mViewModel?.number = mViewModel?.number?.plus(-1)!!
                textView.text = mViewModel?.number.toString()
            }
        }
    }
}