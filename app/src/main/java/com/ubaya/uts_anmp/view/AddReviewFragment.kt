package com.ubaya.uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.ubaya.uts_anmp.R


class AddReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_review, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnAddReview = view.findViewById<Button>(R.id.btnAddReviews)
        btnAddReview.setOnClickListener {
            val action = AddReviewFragmentDirections.actiontoIremHome()
            Navigation.findNavController(it).navigate(action)
        }
    }
}