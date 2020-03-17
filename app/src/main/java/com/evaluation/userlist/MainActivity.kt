package com.evaluation.userlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.evaluation.dagger.data.DataComponent
import com.evaluation.dagger.data.DataComponent.Injector.init

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContentView(R.layout.activity_main)
    }
}