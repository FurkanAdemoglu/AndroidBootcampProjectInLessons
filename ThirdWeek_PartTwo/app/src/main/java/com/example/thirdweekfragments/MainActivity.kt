package com.example.thirdweekfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(),INavigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            supportFragmentManager.commit {
                add<ListFragment>(R.id.containerFragment)
            }
        }

    }



    override fun navigationDetailPage(name:String) {
        supportFragmentManager.commit {
            val bundle=Bundle()
            bundle.putString("HelloKodluyoruz",name)
            setReorderingAllowed(true)
          //  add<ListFragment>(R.id.containerFragment,args=bundle)
            val fragment=DetailFragment()
            fragment.arguments=bundle
            add(R.id.containerFragment,fragment).addToBackStack("detail$name")
        }
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount==0){
            super.onBackPressed()
        }else{
            supportFragmentManager.popBackStack()
        }

    }
}