package com.developerabhi.mamopay.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.developerabhi.mamopay.R
import com.developerabhi.mamopay.interfaces.MyInterfaces
import com.developerabhi.mamopay.presenter.MamoPayPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MyInterfaces.MamoView {

    private var presenter: MamoPayPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter= MamoPayPresenter(this)

    }

    override fun initView() {

    }

    override fun updateView(number:String,numberdot:String) {
        numbervalue.text=number
        dotvalue.text=numberdot
    }

    fun onClickBtn(v: View){
        if (v is Button) {
            presenter?.digitClick(v.text.toString())
        }

    }
    fun onClickDot(v: View){
        presenter?.dotClick()

    }
    fun onClickClear(v: View){
        presenter?.chardelete()
    }
}