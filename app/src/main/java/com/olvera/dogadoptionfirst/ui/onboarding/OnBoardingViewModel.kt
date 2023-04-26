package com.olvera.dogadoptionfirst.ui.onboarding

import androidx.lifecycle.ViewModel
import com.olvera.dogadoptionfirst.R
import com.olvera.dogadoptionfirst.model.domain.OnBoarding
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor() : ViewModel() {

    val data = arrayListOf(
        OnBoarding(
            0,
            R.drawable.ic_launcher_foreground,
            R.string.onboarding_page0_title,
            R.string.onboarding_page0_body
        ),
        OnBoarding(
            1,
            R.drawable.ic_launcher_background,
            R.string.onboarding_page1_title,
            R.string.onboarding_page1_body
        )
    )

    val pages = data.size

    val understoodText = R.string.understood
    val previousText = R.string.previous
    val nextText = R.string.next


}