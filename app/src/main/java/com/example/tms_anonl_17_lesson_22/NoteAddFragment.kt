package com.example.tms_anonl_17_lesson_22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tms_anonl_17_lesson_22.databinding.ActivityMainBinding
import com.example.tms_anonl_17_lesson_22.databinding.FragmentAddBinding
import com.example.tms_anonl_17_lesson_22.databinding.FragmentListBinding
import java.util.Date

class NoteAddFragment : Fragment() {
    private var binding: FragmentAddBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater)
        return binding?.root

    }

    //переопределили метод и вставили адаптер
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //чтобы перейти на предыдущий экран ,вызовем функцию
//        requireActivity().onBackPressedDispatcher.onBackPressed()
        binding?.saveButton?.setOnClickListener {
            val newMote = Note(
                binding?.headerEditText?.text?.toString() ?: "",
                binding?.textEditText?.text?.toString() ?: "",
                Date().toString()
            )
            NotesHolder.notes.add(newMote)
        }
    }
    //метод ондестройвью вызывается каждый раз после возврата на экран
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}