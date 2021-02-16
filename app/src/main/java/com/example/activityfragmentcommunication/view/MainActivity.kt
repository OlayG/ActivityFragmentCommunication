package com.example.activityfragmentcommunication.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.activityfragmentcommunication.databinding.ActivityMainBinding
import com.example.activityfragmentcommunication.model.Person
import com.example.activityfragmentcommunication.view.first.FirstFragment
import com.example.activityfragmentcommunication.view.first.FirstFragmentListener

class MainActivity : AppCompatActivity(), FirstFragmentListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }


        loadFirstFragment()
    }

    private fun loadFirstFragment() {
        supportFragmentManager.beginTransaction().add(
                binding.frameBottom.id,
                FirstFragment.newInstance(),
                "BottomFragment"
        ).commit()
    }

    override fun goToSecond(person: Person) {
        supportFragmentManager.beginTransaction().add(
                binding.frameTop.id,
                SecondFragment.newInstance(person),
                "TopFragment"
        ).commit()
    }
}