package com.example.navigation.fragments.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.base.BaseFragment
import com.example.navigation.models.Pet

class ListFragment:BaseFragment() {
    lateinit var petRecyclerView: RecyclerView
    private val adapter=ListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //recycler view
        initViews(view)
        loadData()
    }
    private fun loadData(){
        val list =ArrayList<Pet>()
        for(i in 0..15){
            list.add(
                Pet(
                    getPetName(i),
                    location = "İzmir",
                    getimageUrl(i)
                    )
            )
        }
        adapter.setPetsData(list)
    }

    private fun getPetName(i:Int):String{
        return if(i%2==0){
            "Lucky"
        }else{
            "Lucky Değil"
        }
    }
    private fun getimageUrl(i:Int):String{
        return if(i%2==0){
            "https://i.guim.co.uk/img/media/684c9d087dab923db1ce4057903f03293b07deac/205_132_1915_1150/master/1915.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=14a95b5026c1567b823629ba35c40aa0"
        }else{
            "https://i.guim.co.uk/img/media/684c9d087dab923db1ce4057903f03293b07deac/205_132_1915_1150/master/1915.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=14a95b5026c1567b823629ba35c40aa0"
        }
    }

    private fun initViews(view: View){
        petRecyclerView=view.findViewById(R.id.petRecyclerView)
      petRecyclerView.layoutManager=LinearLayoutManager(context)
        petRecyclerView.adapter=adapter
        adapter.setPetOnClickListener(object :IPetOnClickListener{
            override fun onClick(pet: Pet) {
                Toast.makeText(context,"${pet.name}",Toast.LENGTH_SHORT).show()
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(
                    pet.name,
                    pet.imageUrl
                )
                findNavController().navigate(action)
            }

        })
    }
}