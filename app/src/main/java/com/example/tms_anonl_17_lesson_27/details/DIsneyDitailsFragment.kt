package com.example.tms_anonl_17_lesson_27.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.tms_anonl_17_lesson_27.R
import com.example.tms_anonl_17_lesson_27.databinding.FragmentDetailsBinding
import com.example.tms_anonl_17_lesson_27.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisneyDitailsFragment : Fragment() {
    private var binding: FragmentDetailsBinding? = null
    private val viewModel: DisneyDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id=arguments?.getInt(IDARG)?:0
        viewModel.onAction(Action.Init (id))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding?.root
    }

    //переопределили метод и вставили адаптер
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        binding?.toolbar?.setNavigationOnClickListener{
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun observeViewModel() {
        viewModel.state.observe(viewLifecycleOwner) { state -> showState(state) }
    }

    private fun showState(state: State) = when (state) {
        is State.Character -> {
            binding?.films?.text=state.films
            binding?.name?.text=state.name
            Glide.with(binding!!.root)
                .load(state.imageUrl)
                .into(binding!!.image)
        }
        State.Progress -> {
            binding?.progress?.isVisible = true
        }
    }



    //метод ондестройвью вызывается каждый раз после возврата на экран
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
companion object {
    private const val IDARG="DETAILSID";
    fun newBundle (id:Int)= bundleOf(IDARG to id)
}

sealed interface State {
        data class Character(val name: String, val films: String, val imageUrl:String) : State
        data object Progress : State
    }
    sealed interface Ivent {
       data object GoBack: Ivent
    }
    sealed interface Action {
        data object BackPress: Action
        data class Init (val id:Int): Action
    }
}