package com.example.tms_anonl_17_lesson_25.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tms_anonl_17_lesson_25.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteAddFragment : Fragment() {
    private var binding: FragmentAddBinding? = null
    private val viewModel: NoteAddViewModel by viewModels()
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
        initView()
        observeViewModel()
    }

    private fun initView() {
        binding?.saveButton?.setOnClickListener {
            viewModel.onAction(
                Action.SaveClick(
                    header = binding?.headerEditText?.text?.toString() ?: "",
                    text = binding?.textEditText?.text?.toString() ?: "",
                )
            )
        }
    }

    private fun observeViewModel() {
        viewModel.event.observe(viewLifecycleOwner) { event -> showEvent(event) }
    }

    private fun showEvent(event: Event) = when (event) {
        Event.GoBack -> {
            //чтобы перейти на предыдущий экран ,вызовем функцию
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    //метод ондестройвью вызывается каждый раз после возврата на экран
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    sealed interface Event {

        data object GoBack : Event
    }

    sealed interface Action {
        data class SaveClick(val header: String, val text: String) : Action
    }
}