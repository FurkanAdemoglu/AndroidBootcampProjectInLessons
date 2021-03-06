package com.example.thirdweekfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailFragment:BaseFragment() {
    lateinit var nameTextView:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =inflater.inflate(R.layout.fragment_detail,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView=view.findViewById(R.id.nameTextView)
        var bundle=this.arguments
        bundle?.let{
            var name=it.getString("HelloKodluyoruz","No name")
            nameTextView.text=name
        }
    }

}