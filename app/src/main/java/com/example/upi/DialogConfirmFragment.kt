package com.example.upi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog_confirm.*


class DialogConfirmFragment : BottomSheetDialogFragment() {
    private val args: DialogConfirmFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_dialog_confirm, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = args.amt
        val receivername = args.receiversname
        text.text = "Do you want to send $amount to $receivername ?"

        yesbtn.setOnClickListener {
            Toast.makeText(requireContext(),"$amount has been sent to $receivername",Toast.LENGTH_SHORT).show()
            dismiss()
        }

        Nobtn.setOnClickListener {
            dismiss()
        }
    }


}