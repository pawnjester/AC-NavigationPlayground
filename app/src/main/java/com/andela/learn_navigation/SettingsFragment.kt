package com.andela.learn_navigation


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.andela.learn_navigation.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_settings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settings_button.setOnClickListener {
            moveToHome(it)
        }
    }

    private fun moveToHome(view: View) {
        val nextAction = SettingsFragmentDirections.actionSettingsFragmentToHomeFragment()
        Navigation.findNavController(view).navigate(nextAction)
    }


}
