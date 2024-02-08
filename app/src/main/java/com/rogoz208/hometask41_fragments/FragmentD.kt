package com.rogoz208.hometask41_fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.hometask41_fragments.databinding.FragmentDBinding

class FragmentD : Fragment(R.layout.fragment_d) {

    private val binding by viewBinding(FragmentDBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toFragmentBButton.setOnClickListener {
            (requireActivity() as? FragmentDPopBackStackRequest)?.onPopBackStackToFragmentBRequested()
        }
    }

    interface FragmentDPopBackStackRequest {
        fun onPopBackStackToFragmentBRequested()
    }

    companion object {
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"

        fun newInstance() = FragmentD()
    }
}