package com.olvera.dogadoptionfirst.ui.onboarding.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.olvera.dogadoptionfirst.databinding.OnboardingPageFragmentBinding
import com.olvera.dogadoptionfirst.model.domain.OnBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OnBoardingPageFragment : Fragment() {

    companion object {

        private const val PAGE = "PAGE"

        @JvmStatic
        fun fragment(page: OnBoarding) =
            OnBoardingPageFragment().apply {
                arguments = Bundle().apply {
                    putString(PAGE, Gson().toJson(page))
                }
            }
    }

    // Properties

    private var _binding: OnboardingPageFragmentBinding? = null
    private val binding get() = _binding!!

    private var page: OnBoarding? = null

    // Initialization

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = OnboardingPageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Arguments
        arguments?.let { arguments ->
            page = Gson().fromJson(arguments.getString(PAGE), OnBoarding::class.java)
        }

        // Setup
        page?.let { page ->
            setup(page)
        }

    }

    // Private

    private fun setup(page: OnBoarding) {

        context?.let { context ->
            startAnimationCoroutine()
            binding.textViewOnboardingTitle.text = context.getString(page.title)
            binding.textViewOnboardingBody.text = context.getString(page.body)
        }

    }

    private fun startAnimationCoroutine() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                binding.animationView.frame = 60
                binding.animationView.setAnimation(page!!.image)
                binding.animationView.progress = 0f
            }
            binding.animationView.playAnimation()
        }
    }

}