package com.example.request.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.request.R
import data.TocModel

class RequestAdapter(
    private val context: Context,
    private val data : List<TocModel>
): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(R.layout.toc_list, parent, false)
        view.findViewById<TextView>(R.id.text_title).text = data[position].title

        val parentTitle = view.findViewById<TextView>(R.id.parent_title)
        parentTitle.text = data[position].parentTitle
        if (position == 0 || (position != 0 && data[position].parentId != data[position-1].parentId)) {
            parentTitle.visibility = View.VISIBLE
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return data.size
    }

}