package com.charder.drawapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.divyanshu.draw.widget.DrawView


class DrawFragment : Fragment() {

    lateinit var draw_view : DrawView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_draw, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        draw_view = view.findViewById(R.id.draw_view)



    }
}