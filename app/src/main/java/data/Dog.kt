package com.example.dogsinfo_vikasm.data

import com.example.dogsinfo_vikasm.R

data class Dog(
    val name: String,
    val age: Int,
    val hobby: String,
    val image: Int
)

val dogs = listOf(

    Dog("Buddy",2,"Loves playing with balls",R.drawable.dog1),
    Dog("Charlie",4,"Enjoys swimming",R.drawable.dog2),
    Dog("Max",3,"Running in parks",R.drawable.dog3),
    Dog("Rocky",5,"Sleeping on sofa",R.drawable.dog4),
    Dog("Daisy",1,"Chasing butterflies",R.drawable.dog5),
    Dog("Bella",3,"Playing with kids",R.drawable.dog6),
    Dog("Luna",2,"Digging in garden",R.drawable.dog7),
    Dog("Milo",4,"Running after frisbee",R.drawable.dog8),
    Dog("Lucy",5,"Watching birds",R.drawable.dog9),
    Dog("Cooper",2,"Eating treats",R.drawable.dog10)

)