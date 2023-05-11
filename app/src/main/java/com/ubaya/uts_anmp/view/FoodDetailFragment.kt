package com.ubaya.uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.ubaya.uts_anmp.R
import com.ubaya.week4_160420064_c.util.loadImage


class FoodDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val names = view.findViewById<TextView>(R.id.txtNameDetail)
        val jaraks = view.findViewById<TextView>(R.id.txtjarakDetail)
        val jambuka = view.findViewById<TextView>(R.id.txtJamBukaDetail)
        val image = view.findViewById<ImageView>(R.id.imgDetail)
        val btnReview = view.findViewById<Button>(R.id.btnReview)
        val nama = FoodDetailFragmentArgs.fromBundle(requireArguments()).nama
        names?.setText(nama)
        jaraks?.setText("Jarak : " + FoodDetailFragmentArgs.fromBundle(requireArguments()).jarak)
        btnReview?.setText(FoodDetailFragmentArgs.fromBundle(requireArguments()).review + " Review")
        jambuka.setText("Jam Buka : 09:00 - 17.00")
        image?.loadImage(FoodDetailFragmentArgs.fromBundle(requireArguments()).photo)
        val btnMenu = view.findViewById<Button>(R.id.btnMenu)
        val btnReservation = view.findViewById<Button>(R.id.btnReservation)
        btnReview.setOnClickListener {
            val action = FoodDetailFragmentDirections.actionReviewFragment()
            Navigation.findNavController(it).navigate(action)
        }
        btnMenu.setOnClickListener {
            val action = FoodDetailFragmentDirections.actionMenuFragment()
            Navigation.findNavController(it).navigate(action)
        }
        btnReservation.setOnClickListener {
            val action = FoodDetailFragmentDirections.actiontoReservation(nama)
            Navigation.findNavController(it).navigate(action)
        }
    }
}