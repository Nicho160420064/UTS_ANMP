package com.ubaya.uts_anmp.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.ubaya.uts_anmp.R

class AddReservationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_reservation, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val names = view.findViewById<TextView>(R.id.txtReservationRestaurantName)
        val btnReservation = view.findViewById<Button>(R.id.btnAddReservation)
        btnReservation.setOnClickListener{
            val action = AddReservationFragmentDirections.actionItemHome()
            Navigation.findNavController(it).navigate(action)
        }
    }

}