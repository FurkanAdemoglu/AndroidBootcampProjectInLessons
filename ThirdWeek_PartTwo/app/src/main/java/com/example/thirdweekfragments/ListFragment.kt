package com.example.thirdweekfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: BaseFragment() {

    private var iNavigation:INavigation?=null
    //lateinit var binding:View
    lateinit var recyclerView: RecyclerView
    private var adapter:ListAdapter= ListAdapter()

    //Bir aktivite bir fragment a atandığında ilk çalışır
    override fun onAttach(context: Context) {
        super.onAttach(context)
        iNavigation=context as INavigation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // binding=inflater.inflate(R.layout.fragment_list,container,false)
        //return binding
      return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setPersonListData()

       // view.findViewById<RecyclerView>(R.id.listRecyclereView)
    // binding.findViewById<RecyclerView>(R.id.listRecyclereView)
    }
    fun initViews(view:View){
        recyclerView=view.findViewById(R.id.listRecyclerView)
        recyclerView.layoutManager=LinearLayoutManager(context)
        adapter.setOnClickListener(object : IOnClickListener{
            override fun onClick(view: View, person: Person) {
                Log.v("Person","$person")
                iNavigation?.navigationDetailPage("${person.name}")

               // var cardView:CardView=view as CardView
                //cardView.setCardBackgroundColor(resources.getColor(R.color.purple_500))
                Toast.makeText(context,"${person.name}",Toast.LENGTH_SHORT).show()

            }
        })
        recyclerView.adapter=adapter

    }

    fun setPersonListData() {
        var list = ArrayList<Person>()
        for(i in 0..100){
            list.add(Person("name $i","${getLocation(i)}"))
        }
        adapter.setPersonList(list)
    }

    fun  getLocation(n:Int):String{
        return if(n%2==0){
            "Istanbul"
        }else{
            "Ankara"
        }
    }


}