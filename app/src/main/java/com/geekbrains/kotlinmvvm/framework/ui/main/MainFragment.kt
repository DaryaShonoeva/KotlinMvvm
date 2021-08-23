package com.geekbrains.kotlinmvvm.framework.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.geekbrains.kotlinmvvm.AppState
import com.geekbrains.kotlinmvvm.R
import com.geekbrains.kotlinmvvm.databinding.MainFragmentBinding
import com.geekbrains.kotlinmvvm.model.entities.Description
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private var _binding : MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observer = Observer<AppState> { renderData(it)}
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getFilms()
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                val filmData = appState.filmData
                progressBar.visibility = View.GONE
                setData(filmData)
            }
            is AppState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getFilms() }
                    .show()
            }
        }

    }
    private fun setData(filmData: Description) = with(binding) {
        filmName.text = filmData.name.name
        filmCategories.text = filmData.categories.toString()
        filmDuration.text = filmData.duration.toString()
        filmRating.text = filmData.rating.toString()
        filmBudget.text = filmData.budget.toString()
        filmDescription.text = filmData.description.toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        fun newInstance() = MainFragment()
    }

}