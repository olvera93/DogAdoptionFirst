package com.olvera.dogadoptionfirst.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.olvera.dogadoptionfirst.R
import com.olvera.dogadoptionfirst.config.AppPrefs
import com.olvera.dogadoptionfirst.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val dogList = binding.rvNewDogs
        homeViewModel.dogList.observe(viewLifecycleOwner) {
            dogList.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )

            dogList.adapter = HomeAdapter(it) { dog ->
                homeViewModel.addDogToUser(
                    AppPrefs(requireContext()).getEmail().toString(),
                    dog.dogId,
                    dog.dogName,
                    dog.imageUrl,
                    dog.dogAge
                )
                Snackbar.make(
                    requireView(),
                    getString(R.string.adopted_dogs, dog.dogName),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        val dogq = binding.rvAllDogs
        homeViewModel.dogList.observe(viewLifecycleOwner) {
            dogq.layoutManager = GridLayoutManager(requireContext(), 2)
            dogq.adapter = HomeAdapter(it) { dog ->
                homeViewModel.addDogToUser(
                    AppPrefs(requireContext()).getEmail().toString(),
                    dog.dogId,
                    dog.dogName,
                    dog.imageUrl,
                    dog.dogAge
                )
                Snackbar.make(
                    requireView(),
                    getString(R.string.adopted_dogs, dog.dogName),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}