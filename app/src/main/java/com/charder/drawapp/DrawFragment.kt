package com.charder.drawapp

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.divyanshu.draw.activity.DrawingActivity
import com.divyanshu.draw.widget.DrawView


class DrawFragment : Fragment() {

    lateinit var draw_view : DrawView
    lateinit var bt_draw : Button
    lateinit var imageView : ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_draw, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        draw_view = view.findViewById(R.id.draw_view)
        imageView = view.findViewById(R.id.imageView)
        bt_draw = view.findViewById(R.id.bt_draw)
        bt_draw.setOnClickListener {
            val intent = Intent(requireContext(), DrawingActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_DRAW)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null && resultCode == Activity.RESULT_OK) {
            when(requestCode){
                REQUEST_CODE_DRAW -> {
                    val result= data.getByteArrayExtra("bitmap")
                    val bitmap = BitmapFactory.decodeByteArray(result, 0, result.size)
//                    saveImage(bitmap)
                    imageView.setImageBitmap(bitmap)
                }
            }
        }
    }
}