package com.example.navigation.fragments.list

import com.example.navigation.models.Pet

interface IPetOnClickListener {
    fun onClick(name: Pet)
}