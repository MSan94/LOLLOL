package com.myprj.msan.lollol.fragment.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.myprj.msan.lollol.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    interface onDataPassListener{
        fun onDataSend(buttonId : Int?)
    }

    lateinit var  dataPassListener: onDataPassListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPassListener = context as onDataPassListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button_1: AppCompatButton = view.findViewById(R.id.imageButton_1)
        val button_2: AppCompatButton = view.findViewById(R.id.imageButton_2)
        val button_3: AppCompatButton = view.findViewById(R.id.imageButton_3)
        val button_4: AppCompatButton = view.findViewById(R.id.imageButton_4)
        val button_5: AppCompatButton = view.findViewById(R.id.imageButton_5)
        val button_6: AppCompatButton = view.findViewById(R.id.imageButton_6)

        button_1.setOnClickListener { dataSend(button_1) }
        button_2.setOnClickListener { dataSend(button_2) }
        button_3.setOnClickListener { dataSend(button_3) }
        button_4.setOnClickListener { dataSend(button_4) }
        button_5.setOnClickListener { dataSend(button_5) }
        button_6.setOnClickListener { dataSend(button_6) }

    }

    private fun dataSend(appCompatButtonId : AppCompatButton){
        when(appCompatButtonId.id) {
            R.id.imageButton_1 -> dataPassListener.onDataSend(1)
            R.id.imageButton_2 -> dataPassListener.onDataSend(2)
            R.id.imageButton_3 -> dataPassListener.onDataSend(3)
            R.id.imageButton_4 -> dataPassListener.onDataSend(4)
            R.id.imageButton_5 -> dataPassListener.onDataSend(5)
            R.id.imageButton_6 -> dataPassListener.onDataSend(6)
        }
    }

}