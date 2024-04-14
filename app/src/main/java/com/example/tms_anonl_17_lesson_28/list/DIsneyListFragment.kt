package com.example.tms_anonl_17_lesson_28.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tms_anonl_17_lesson_28.R
import com.example.tms_anonl_17_lesson_28.databinding.FragmentListBinding
import com.example.tms_anonl_17_lesson_28.details.DisneyDitailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DIsneyListFragment : Fragment() {
    private var binding: FragmentListBinding? = null
    private val adapter = DisneyCharacterRecyclerViewAdapter{id->
        viewModel.onAction(Action.OnItemClick(id))
    }
    private val viewModel: DisneyListViewModel by viewModels()
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
        initView()
        observeViewModel()
    }

    private fun initView() {
        binding?.recycler?.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.state.observe(viewLifecycleOwner) { state -> showState(state) }
        viewModel.ivent.observe(viewLifecycleOwner) { ivent -> showIvent(ivent) }
    }
    @Suppress("UNREACHABLE_CODE")
    private fun showIvent(ivent: Ivent) = when (ivent) {
        is Ivent.GotoDetails -> {
            throw RuntimeException("Test Crash") // Force a crash

            val fragment = DisneyDitailsFragment()
            fragment.arguments=DisneyDitailsFragment.newBundle(ivent.id)
            //контейнер в маин лояут активити пустой, мы вставляем туда фрагмент
           parentFragmentManager.beginTransaction()
               .addToBackStack("DisneyDitailsFragment")
               .replace(R.id.container, fragment)
               .commit()
        }
    }
    private fun showState(state: State) = when (state) {
        is State.Characters -> {
            adapter.update(state.items)
            binding?.progress?.isVisible = false
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

    sealed interface State {
        data class Characters(val items: List<DisneyCharacter>) : State
        object Progress : State
    }
    sealed interface Action {
        data class OnItemClick (val id:Int): Action
    }
    sealed interface Ivent {
        data class GotoDetails (val id:Int): Ivent
    }
}