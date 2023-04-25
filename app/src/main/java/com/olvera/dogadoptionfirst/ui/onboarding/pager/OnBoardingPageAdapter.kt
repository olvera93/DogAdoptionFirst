package com.olvera.dogadoptionfirst.ui.onboarding.pager

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.olvera.dogadoptionfirst.model.domain.OnBoarding

class OnBoardingPageAdapter(
    context: AppCompatActivity,
    private var pages: List<OnBoarding>
): FragmentStateAdapter(context) {

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun createFragment(position: Int): OnBoardingPageFragment {
        val page = pages[position]
        return OnBoardingPageFragment.fragment(page)
    }

}