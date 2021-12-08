package com.example.superhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superhero.databinding.FragmentSuperheroListBinding


class SuperheroListFragment : Fragment(R.layout.fragment_superhero_list) {
    private lateinit var binding: FragmentSuperheroListBinding
    private val viewModel: SuperheroListViewModel by viewModels()
    private var listAdapter: SuperheroAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getListHeroes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperheroListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        observe()
        binding.spinner.setSelection(8)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                viewModel.changeList(parentView?.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
            }
        }
    }

    private fun initList() {
        listAdapter = SuperheroAdapter { hero ->
            val action =
                SuperheroListFragmentDirections.actionSuperheroListFragmentToDetailsFragment2(hero)
            findNavController().navigate(action)
        }
        with(binding.superheroList) {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun observe() {
        viewModel.heroes.observe(viewLifecycleOwner) { newlist ->
            listAdapter?.updateList(newlist)
        }
    }
}