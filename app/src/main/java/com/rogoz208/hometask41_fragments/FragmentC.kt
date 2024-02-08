package com.rogoz208.hometask41_fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.hometask41_fragments.databinding.FragmentCBinding

class FragmentC : Fragment(R.layout.fragment_c) {

    private val binding by viewBinding(FragmentCBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            binding.helloStringTextView.text = it.getString(HELLO_STRING_EXTRA_KEY)
        }

        val activity = requireActivity() as? FragmentCButtonClickListener

        binding.toFragmentDButton.setOnClickListener {
            activity?.onToFragmentDButtonClicked()
        }

        binding.toFragmentAButton.setOnClickListener {
            activity?.onToFragmentAButtonClicked()
        }
    }

    interface FragmentCButtonClickListener {
        fun onToFragmentDButtonClicked()
        fun onToFragmentAButtonClicked()
    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

        private const val HELLO_STRING_EXTRA_KEY = "HELLO_STRING_EXTRA_KEY"

        fun newInstance(helloString: String) = FragmentC().apply {
            arguments = bundleOf(HELLO_STRING_EXTRA_KEY to helloString)
        }
    }
}