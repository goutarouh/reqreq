package com.example.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.request.adapter.RequestAdapter

class MainFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.request_button)?.let {
            it.setOnClickListener {
                val requestDialogFragment = RequestDialogFragment()
                requestDialogFragment.show(childFragmentManager, this::class.java.name)
            }
        }
    }
}