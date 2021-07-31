package com.example.navigation.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.navigation.R
import com.example.navigation.base.BaseFragment

class DetailFragment:BaseFragment() {
    val args:DetailFragmentArgs by navArgs()

    private lateinit var nameTextView: TextView
    private lateinit var avatarImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       initViews(view)
        handleArgs()
    }
    private fun handleArgs(){
        args.name?.let {
            nameTextView.text=it
        }
        args.url?.let {
            Glide.with(this)
                .load(it)
                .placeholder(R.mipmap.ic_launcher)
                .into(avatarImageView)
        }
    }
    private fun initViews(view: View){
        nameTextView=view.findViewById(R.id.detailNameTextView)
        avatarImageView=view.findViewById(R.id.avatarImageView)
    }
}