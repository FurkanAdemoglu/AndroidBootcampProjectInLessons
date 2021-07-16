package com.example.firstweekcodes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity(),IUploadPhoto {

    override fun onStart() {
        super.onStart()
        Log.v("ProjectApp","Activity is onStart")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager=supportFragmentManager
        val detailFragment=DetailFragment()
        val transaction=fragmentManager.beginTransaction()
       transaction.add(R.id.fragment_container_view,detailFragment,"DetailFragment")
        transaction.commitAllowingStateLoss()
        Log.v("ProjectApp","Activity is onCreate")

        //val button=findViewById<Button>(R.id.helloButton)
       // button.setOnClickListener {
            //Log.v("Kodluyoruz","debug point")
           // val intent= Intent(this,DetailActivity::class.java)
            //startActivity(intent)
           /* val actionSendString="Merhaba Kodluyoruz"
            val intent=Intent().apply {
                action=Intent.ACTION_SEND
                type="text/plain"
                putExtra(Intent.EXTRA_TEXT,actionSendString)
                setPackage("com.google.android.apps.translate")
            }
            startActivity(intent)*/

            //Creates an Intent
           /* val gmmIntentUri= Uri.parse("geo:41.013948,28.966084")
            val mapIntent=Intent(Intent.ACTION_VIEW,gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)*/
        }


    override fun onResume() {
        super.onResume()
        Log.v("ProjectApp","Activity is onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ProjectApp","Activity is onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ProjectApp","Activity is onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ProjectApp","Activity is onDestroy")
    }

    override fun onPhotoUpload(url: String) {
        Log.v("ProjectApp","Activity is onPhotoUpload - paramater:$url")
    }
}