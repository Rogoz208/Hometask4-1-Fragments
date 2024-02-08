package com.rogoz208.hometask41_fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.hometask41_fragments.databinding.FragmentABinding

class FragmentA : Fragment(R.layout.fragment_a) {

    private val binding by viewBinding(FragmentABinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toFragmentBButton.setOnClickListener {
            (requireActivity() as? FragmentAButtonClickListener)?.onToFragmentBButtonClicked()
        }
    }

    interface FragmentAButtonClickListener {
        fun onToFragmentBButtonClicked()
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

        fun newInstance() = FragmentA()
    }
}