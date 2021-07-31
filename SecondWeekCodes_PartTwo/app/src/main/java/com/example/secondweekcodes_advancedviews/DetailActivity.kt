package com.example.secondweekcodes_advancedviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

    val TAG="DetailActivity"
    lateinit var nameTextView:TextView
    lateinit var kindTextView: TextView
    lateinit var locationTextView:TextView
    lateinit var likeButton:Button
    lateinit var adoptButton:Button
    lateinit var contactButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
        handleIntent(intent)
        addListeners()

    }

    private fun initViews(){
        nameTextView=findViewById(R.id.nameTextView)
        kindTextView=findViewById(R.id.kindTextView)
        locationTextView=findViewById(R.id.locationTextView)
        likeButton=findViewById(R.id.likeButton)
        contactButton=findViewById(R.id.contactButton)
        adoptButton=findViewById(R.id.adoptButton)

    }

    private fun handleIntent(intent: Intent?){
        intent?.let {
            it.getStringExtra(MainActivity.PET_ID)?.let{petId->
                Log.v(TAG,"Pet ID =$petId")
                nameTextView.text=petId
                kindTextView.text="Yorki"
                locationTextView.text="Istanbul"
            }
        }
    }

    private fun addListeners(){
        likeButton.setOnClickListener {
            Toast.makeText(baseContext,"Like Button",Toast.LENGTH_SHORT).show()
        }

        contactButton.setOnClickListener {
            Toast.makeText(baseContext,"Contact Button",Toast.LENGTH_SHORT).show()
        }

        adoptButton.setOnClickListener {
            Toast.makeText(baseContext,"Adopt Button",Toast.LENGTH_SHORT).show()
        }
    }
}