package com.xlh.mr.knightapp

import android.app.AppComponentFactory
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 *
 *@Author Dain
 *
 *@Data 2019/7/5-15:05
 *
 */
class FreeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.act_free)
        setContentView(R.layout.activity_main)


    }
}