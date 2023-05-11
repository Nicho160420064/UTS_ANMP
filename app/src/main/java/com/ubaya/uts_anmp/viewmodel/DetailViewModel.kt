package com.ubaya.uts_anmp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.ubaya.uts_anmp.model.Food

class DetailViewModel: ViewModel() {
    val TAG = "volleytag"
    private var queue: RequestQueue? = null
    val foodLD = MutableLiveData<Food>()

}