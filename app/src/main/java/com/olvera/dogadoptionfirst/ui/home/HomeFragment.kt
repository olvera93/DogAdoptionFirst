package com.olvera.dogadoptionfirst.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.olvera.dogadoptionfirst.config.AppPrefs
import com.olvera.dogadoptionfirst.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var homeViewModel2: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel2 =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // aparezca el dogList
        val dogList = binding.rvDogs
        homeViewModel2.dogList.observe(viewLifecycleOwner) {
            dogList.layoutManager = LinearLayoutManager(context)

            dogList.adapter = HomeAdapter(it) { dog ->
                Log.i("DOGI: ", "onCreateView: ${dog.name}")
                homeViewModel2.insertDog(dog)
                homeViewModel2.addDogToUser(
                    AppPrefs(requireContext()).getEmail().toString(),
                    dog.id,
                    dog.name,
                    dog.imageUrl,
                )
            }
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}