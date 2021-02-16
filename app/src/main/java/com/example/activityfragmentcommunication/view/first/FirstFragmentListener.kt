package com.example.activityfragmentcommunication.view.first

import android.content.Context
import com.example.activityfragmentcommunication.model.Person


interface FirstFragmentListener {

    fun goToSecond(person: Person)
}