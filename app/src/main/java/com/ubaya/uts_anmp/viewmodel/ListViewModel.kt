package com.ubaya.uts_anmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.uts_anmp.model.Food
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application) : AndroidViewModel(application){
    private var queue: RequestQueue? = null
    val TAG = "volleyTag"
    val foodsLD = MutableLiveData<ArrayList<Food>>()
    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://my-json-server.typicode.com/Nicho160420064/food/food"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Food>>() { }.type
                val result = Gson().fromJson<List<Food>>(it, sType)
                foodsLD.value = result as ArrayList<Food>
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}