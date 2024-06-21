package com.example.android2homework28.ui.fragments.onborad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.android2homework28.R
import com.example.android2homework28.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private var _binding: FragmentOnBoardPagingBinding? = null
    private val binding: FragmentOnBoardPagingBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize()= with(binding)  {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0->{
                onTxt.text = "Очень удобный функционал"
                binding.lottieAnimationSecond.setAnimation(R.raw.first_animation)
            }
            1->{
                onTxt.text = "Быстрый, качественный продукт"
                binding.lottieAnimationSecond.setAnimation(R.raw.second_animation)
            }
            2->{
                onTxt.text = "Куча функций и интересных фишек"
                binding.start.isVisible = true
                binding.lottieAnimationSecond.setAnimation(R.raw.third_animation)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}