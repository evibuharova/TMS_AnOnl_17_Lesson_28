package com.example.tms_anonl_17_lesson_22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tms_anonl_17_lesson_22.databinding.ActivityMainBinding
import com.example.tms_anonl_17_lesson_22.databinding.FragmentListBinding

class NoteListFragment : Fragment() {
    private var binding: FragmentListBinding? = null
    private val adapter = NotesRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        return binding?.root
    }

    //переопределили метод и вставили адаптер
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recycler?.adapter = adapter
        adapter.update(NotesHolder.notes)
        binding?.addButton?.setOnClickListener {
            //контейнер в маин лояут активити пустой, мы вставляем туда фрагмент
            val fragment = NoteAddFragment()
            parentFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack("back").commit()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.update(NotesHolder.notes)
    }
    //метод ондестройвью вызывается каждый раз после возврата на экран
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}