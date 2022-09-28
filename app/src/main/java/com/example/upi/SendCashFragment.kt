package com.example.upi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_cash.*


class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    private val args: SendCashFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //How to receive data while using bundles

//        val receiverName = arguments?.getString("name")
//        receivercashname.text = "Send Cash to $receiverName"


        //How to receive data while using safe args
        //add args class made by safeargs globally at the top
        val receiverName = args.recname

        receivercashname.text = "Send cash to $receiverName"

        send_button.setOnClickListener {

            val amounnt = cash.text.toString().toLong()

            val action = SendCashFragmentDirections.actionSendCashFragmentToDialogConfirmFragment(
                receiverName,
                amounnt
            )
            findNavController().navigate(action)
        }

        doneButton.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        cancelbtn.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,true)
        }

    }


}