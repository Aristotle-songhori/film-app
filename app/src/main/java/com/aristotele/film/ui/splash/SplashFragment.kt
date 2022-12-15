package com.aristotele.film.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.aristotele.film.R
import com.aristotele.film.databinding.FragmentSplashBinding
import com.aristotele.film.utils.StoreUserData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject


@AndroidEntryPoint
class SplashFragment : Fragment() {

    //Binding
    private lateinit var binding: FragmentSplashBinding


    @Inject
    lateinit var storeUserData : StoreUserData



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Set delay
        lifecycle.coroutineScope.launchWhenCreated {
            delay(2000)
//for test
           // findNavController().navigate(R.id.action_splashFragment_to_homeFragment2)

            //Check user token
            storeUserData.getUserToken().collect {
                if (it.isEmpty()) {
                    findNavController().navigate(R.id.action_splashFragment_to_registerFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment2)
                }
            }
        }
    }
}