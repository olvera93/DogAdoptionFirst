package com.olvera.dogadoptionfirst.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.olvera.dogadoptionfirst.R
import com.olvera.dogadoptionfirst.config.AppPrefs
import com.olvera.dogadoptionfirst.databinding.ActivityOnBoardingBinding
import com.olvera.dogadoptionfirst.ui.login.LoginActivity
import com.olvera.dogadoptionfirst.ui.onboarding.pager.OnBoardingPageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var viewModel: OnBoardingViewModel

    private var selection = 0
    private var dots: Array<TextView?> = arrayOfNulls(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        // View Model
        viewModel = ViewModelProvider(this)[OnBoardingViewModel::class.java]

        // Setup
        localize()
        setup()
    }


    private fun localize() {

        binding.buttonPrev.text = getText(viewModel.previousText)
        binding.buttonNext.text = getText(viewModel.nextText)
    }

    private fun setup() {

        // Adapter
        slider()

        // Dots
        dots(0)

        // Buttons

        binding.buttonNext.setOnClickListener {
            if (selection == viewModel.pages - 1) {
                AppPrefs(this).setFirstTimeLaunch(false)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                selection += 1
                binding.viewPagerOnboarding.setCurrentItem(selection, true)
            }
        }

        binding.buttonPrev.setOnClickListener {
            selection -= 1
            binding.viewPagerOnboarding.setCurrentItem(selection, true)
        }
    }

    private fun slider() {


        binding.viewPagerOnboarding.adapter = OnBoardingPageAdapter(this, viewModel.data)

        binding.viewPagerOnboarding.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                dots(position)
                selection = position

                binding.buttonPrev.visibility = if (position == 0) View.INVISIBLE else View.VISIBLE
                binding.buttonNext.text =
                    getText(if (position == viewModel.pages - 1) viewModel.understoodText else viewModel.nextText)
            }
        })
    }

    private fun dots(position: Int) {
        dots = arrayOfNulls(viewModel.pages)
        binding.layoutDots.removeAllViews()
        for (index in dots.indices) {
            dots[index] = TextView(this)
            dots[index]?.text = Html.fromHtml("•")
            dots[index]?.textSize = 35f
            dots[index]?.setTextColor(getColor(if (index == position) R.color.black else androidx.cardview.R.color.cardview_dark_background))
            binding.layoutDots.addView(dots[index])
        }
    }
}