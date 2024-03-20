package com.example.tms_anonl_17_lesson_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.tms_anonl_17_lesson_22.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val fragment = NoteListFragment()
        //контейнер в маин лояут активити пустой, мы вставляем туда фрагмент
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}