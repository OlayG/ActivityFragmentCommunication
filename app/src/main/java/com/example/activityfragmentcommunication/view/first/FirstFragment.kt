package com.example.activityfragmentcommunication.view.first

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.activityfragmentcommunication.databinding.FragmentFirstBinding
import com.example.activityfragmentcommunication.model.Person

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    /**
     * Declare listener to communicate with activity
     */
    private var listener: FirstFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /**
         * Initialize the listener to communicate with activity
         */
        listener = if (context is FirstFragmentListener) {
            context
        } else {
            throw RuntimeException("$context must implement FirstFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFirstBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClick.setOnClickListener {
            listener?.goToSecond(Person("Tom", "Brady"))
        }
    }

    fun setListener(listener: FirstFragmentListener) {
        this.listener = listener
    }

    companion object {
        fun newInstance() = FirstFragment()
    }

}