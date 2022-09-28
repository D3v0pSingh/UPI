package com.example.upi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class homeFragment : Fragment(R.layout.fragment_home) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        sendbtn.setOnClickListener {
            val action = homeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }

        balbtn.setOnClickListener {
            val action = homeFragmentDirections.actionHomeFragmentToBalanceFragment()
            navController.navigate(action)
        }

        transbtn.setOnClickListener {
            val action = homeFragmentDirections.actionHomeFragmentToTransactionFragment()
            navController.navigate(action)
        }
    }


}