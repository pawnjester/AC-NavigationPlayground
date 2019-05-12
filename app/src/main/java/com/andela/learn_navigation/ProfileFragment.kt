package com.andela.learn_navigation

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.andela.learn_navigation.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val passedString = arguments?.getString("passed_string")
//        Log.e("hereisthestring",passedString?: "nope")

        arguments?.let {
            val safeArgs = ProfileFragmentArgs.fromBundle(it)
            binding.profileName.text = "${safeArgs.profileName}"
        }

        profile_button.setOnClickListener {
            moveToSettings(it)
        }

    }

    private fun moveToSettings(view: View) {
        val nextAction = ProfileFragmentDirections.actionProfileFragmentToSettingsFragment()
        Navigation.findNavController(view).navigate(nextAction)
    }
}
