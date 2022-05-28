package com.zhr.test

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

/**
 * 使用了ViewModel 加上 LiveData
 * 因为使用了ViewModel 所以屏幕旋转时 数据不会重新创建
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var viewModel: NumberViewModel? = null
    private lateinit var textView: TextView
    private lateinit var add: Button
    private lateinit var reduce: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 创建ViewModel
        viewModel = ViewModelProvider(this).get(NumberViewModel::class.java)
        initView()
        // 对ViewModel中的数据变动进行监听
        // 这里的T 就是监听变动数据的数据类型
        viewModel?.num?.observe(this, object : Observer<Int> {
            override fun onChanged(t: Int?) {
                runOnUiThread {
                    textView.text = t.toString()
                }
            }
        })
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
            R.id.add -> viewModel?.add1()
            R.id.reduce -> viewModel?.reduce1()
        }
    }
}