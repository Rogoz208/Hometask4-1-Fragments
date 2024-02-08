package com.rogoz208.hometask41_fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.hometask41_fragments.databinding.FragmentBBinding

class FragmentB : Fragment(R.layout.fragment_b) {

    private val binding by viewBinding(FragmentBBinding::bind)
    private val helloString: String = "Hello Fragment C"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as? FragmentBButtonClickListener

        binding.toFragmentCButton.setOnClickListener {
            activity?.onToFragmentCButtonClicked(helloString)
        }

        binding.backButton.setOnClickListener {
            activity?.onBackButtonClicked()
        }
    }

    interface FragmentBButtonClickListener {
        fun onToFragmentCButtonClicked(helloString: String)
        fun onBackButtonClicked()
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        fun newInstance() = FragmentB()
    }
}