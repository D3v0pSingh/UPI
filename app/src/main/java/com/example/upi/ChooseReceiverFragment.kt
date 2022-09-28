package com.example.upi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*


class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        sendbtn.setOnClickListener {

            //Method 1: How to send data using bundles without
            //giving lines in navGraph

//            val receivername = receivername.text.toString()
//            val args = Bundle()
//            args.putString("name", receivername)
//            navController.navigate(R.id.sendCashFragment,args)


            //Method 2: using safe args to transfer data

            val revname = receivername.text.toString()
            val action = ChooseReceiverFragmentDirections.
            actionChooseReceiverFragmentToSendCashFragment2(revname)
            navController.navigate(action)
        }

        cancelbtn.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,true)
        }
    }

}