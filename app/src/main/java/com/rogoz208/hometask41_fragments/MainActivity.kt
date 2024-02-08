package com.rogoz208.hometask41_fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.hometask41_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main),
    FragmentA.FragmentAButtonClickListener, FragmentB.FragmentBButtonClickListener,
    FragmentC.FragmentCButtonClickListener, FragmentD.FragmentDPopBackStackRequest {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportFragmentManager.findFragmentByTag(FragmentA.FRAGMENT_A_TAG) == null) {
            supportFragmentManager.commit {
                val fragment = FragmentA.newInstance()
                replace(binding.fragmentContainer.id, fragment, FragmentA.FRAGMENT_A_TAG)
            }
        }
    }

    override fun onToFragmentBButtonClicked() {
        supportFragmentManager.commit {
            val fragment = FragmentB.newInstance()
            replace(binding.fragmentContainer.id, fragment, FragmentB.FRAGMENT_B_TAG)
            addToBackStack(FragmentB.FRAGMENT_B_TAG)
        }
    }

    override fun onToFragmentCButtonClicked(helloString: String) {
        supportFragmentManager.commit {
            val fragment = FragmentC.newInstance(helloString)
            replace(binding.fragmentContainer.id, fragment, FragmentC.FRAGMENT_C_TAG)
            addToBackStack(FragmentC.FRAGMENT_C_TAG)
        }
    }

    override fun onBackButtonClicked() {
        supportFragmentManager.popBackStack()
    }

    override fun onToFragmentDButtonClicked() {
        supportFragmentManager.commit {
            val fragment = FragmentD.newInstance()
            replace(binding.fragmentContainer.id, fragment, FragmentD.FRAGMENT_D_TAG)
            addToBackStack(FragmentD.FRAGMENT_D_TAG)
        }
    }

    override fun onToFragmentAButtonClicked() {
        supportFragmentManager.popBackStack(
            FragmentB.FRAGMENT_B_TAG,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    override fun onPopBackStackToFragmentBRequested() {
        supportFragmentManager.popBackStack(FragmentB.FRAGMENT_B_TAG, 0)
    }
}