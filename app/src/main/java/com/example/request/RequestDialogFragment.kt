package com.example.request

import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import androidx.fragment.app.DialogFragment
import com.example.request.adapter.RequestAdapter
import com.example.request.util.easyPrint
import data.TocModel


class RequestDialogFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.request_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        "onViewCreated".easyPrint()

        val data = listOf<TocModel>(
            TocModel("title1", 0, 0,"parent0"),
            TocModel("title2", 1, 0,"parent0"),
            TocModel("title3", 2, 1,"parent1"),
            TocModel("title4", 3, 2,"parent2"),
            TocModel("title5", 4, 2,"parent2")
        )

        val requestAdapter =  RequestAdapter(requireContext(), data)
        val listView = view.findViewById<ListView>(R.id.request_list)
        listView.adapter = requestAdapter

        view.findViewById<Button>(R.id.toc_button).setOnClickListener {
            val count = listView.count
            for (i in 0.until(count)) {
                val checkBox = listView.getChildAt(i).findViewById<CheckBox>(R.id.check_box)
                if (checkBox.isChecked) {
                    data[i].tocId.easyPrint()
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        "onActivityCreated".easyPrint()
        val dialog: Dialog? = dialog
        val lp = dialog?.window?.attributes
        val metrics: DisplayMetrics = resources.displayMetrics

        val dialogWidth = (metrics.widthPixels * 0.8).toInt()
        val dialogHeight = (metrics.heightPixels * 0.8).toInt()
        lp?.width = dialogWidth
        lp?.height = dialogHeight
        dialog?.window?.attributes = lp
    }
}
