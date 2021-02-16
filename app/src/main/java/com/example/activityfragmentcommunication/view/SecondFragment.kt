package com.example.activityfragmentcommunication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activityfragmentcommunication.databinding.FragmentSecondBinding
import com.example.activityfragmentcommunication.model.Person

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        person = arguments?.getParcelable(PERSON_PARAM)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSecondBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateDisplay()
    }

    private fun updateDisplay() = with(binding.tvDisplay) {
        text = person.toString()
    }

    fun updateDisplayDirectFromActivity(
        person: Person
    ) = with(binding.tvDisplay) {
        text = person.toString()
    }

    companion object {
        private const val PERSON_PARAM = "Person Param"

        fun newInstance(person: Person): SecondFragment {
            val secondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putParcelable(PERSON_PARAM, person)
            secondFragment.arguments = bundle
            return secondFragment
        }
    }

}