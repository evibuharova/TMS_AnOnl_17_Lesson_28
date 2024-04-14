package com.example.tms_anonl_17_lesson_28

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_anonl_17_lesson_28.databinding.ActivityMainBinding
import com.example.tms_anonl_17_lesson_28.list.DIsneyListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val fragment = DIsneyListFragment()
        //контейнер в маин лояут активити пустой, мы вставляем туда фрагмент
        supportFragmentManager.beginTransaction()
            .addToBackStack("DIsneyListFragment")
            .replace(R.id.container, fragment)
            .commit()

    }
}