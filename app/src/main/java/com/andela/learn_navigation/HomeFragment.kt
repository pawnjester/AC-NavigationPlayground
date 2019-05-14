package com.andela.learn_navigation


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.andela.learn_navigation.R.id.home_button
import com.andela.learn_navigation.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,
                container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        home_button.setOnClickListener {
//            val args = Bundle()
//            args.putString("passed_string", binding.name.text.toString())
//            navController = Navigation.findNavController(
//                    activity!!, R.id.my_nav_host_fragment )
//            navController.navigate(R.id.action_homeFragment_to_profileFragment, args)
            val nextAction = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
            nextAction.setProfileName(binding.name.text.toString())
            Navigation.findNavController(it).navigate(nextAction)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
