package com.olvera.dogadoptionfirst.ui.settings

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
import com.olvera.dogadoptionfirst.config.AppPrefs
import dagger.hilt.android.AndroidEntryPoint
import com.olvera.dogadoptionfirst.databinding.FragmentSettingsBinding
import com.olvera.dogadoptionfirst.model.domain.User
import com.olvera.dogadoptionfirst.ui.login.LoginActivity
import com.olvera.dogadoptionfirst.ui.signup.SignUpViewModel


@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]

        setUp()

        return root
    }

    private fun setUp() {
        val email = AppPrefs(requireContext()).getEmail()
        email?.let { viewModel.getUser(it) }

        viewModel.user.observe(viewLifecycleOwner) { user ->
            user?.let {
                binding.apply {
                    textName.text = user.userName
                    textEmail.text = user.userEmail
                    buttonLogout.setOnClickListener {
                        AppPrefs(requireContext()).setFirstTimeLaunch(true)
                        startActivity(Intent(requireContext(), LoginActivity::class.java))
                        requireActivity().finish()

                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}