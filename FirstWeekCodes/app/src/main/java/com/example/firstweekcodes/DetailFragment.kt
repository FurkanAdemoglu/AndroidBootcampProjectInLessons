package com.example.firstweekcodes

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

class DetailFragment: Fragment() {

    //lateinit var mainActivity: MainActivity
    lateinit var photoUtil:IUploadPhoto

    override fun onAttach(context: Context) {
        super.onAttach(context)
     //   mainActivity=context as MainActivity
        photoUtil=context as IUploadPhoto
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoUtil.onPhotoUpload("bir dosyanın url path.")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)
    }
}