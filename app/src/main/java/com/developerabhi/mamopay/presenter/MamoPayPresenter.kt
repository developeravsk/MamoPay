package com.developerabhi.mamopay.presenter


import com.developerabhi.mamopay.interfaces.MyInterfaces
import com.developerabhi.mamopay.model.MamoDataModel
import java.lang.NumberFormatException
import java.text.NumberFormat
import java.util.*

class MamoPayPresenter(private var view: MyInterfaces.MamoView) : MyInterfaces.MamoPresenter {

    private var model: MyInterfaces.MamoModel = MamoDataModel()

    init {
        view.initView()
    }

    override fun dotClick() {
        if (model.getdotClickStatus() == false) {
            model.dotClickStatusUpdate(true)
        } else {
            model.dotClickStatusUpdate(false)
        }
        updateView()
    }

    override fun digitClick(text: String) {
        if (model.getdotClickStatus() == true) {
            if (model.getDotValue().length < 2) {
                model.dotValueUpdate(model.getDotValue() + text)
            }

        } else {
            if (model.getValue().length < 8) {
                model.valueUpdate(model.getValue() + text)
            }
        }
        updateView()

    }

    override fun chardelete() {

        if (model.getdotClickStatus() == true) {
            if (model.getDotValue().length > 1) {
                model.dotValueUpdate(
                    model.getDotValue().substring(0, model.getDotValue().length - 1)
                )
            } else {
                model.dotClickStatusUpdate(false)
                model.dotValueUpdate("")
            }
        } else {
            try {
                model.valueUpdate(model.getValue().substring(0, model.getValue().length - 1))
            } catch (e: StringIndexOutOfBoundsException) {
                e.printStackTrace()
            }
        }
        updateView()
    }

    private fun updateformat(value: String): String {
        try {
            return NumberFormat.getNumberInstance(Locale.US).format(value.toLong())
        } catch (e: NumberFormatException) {
            if (value != "") {
                val number = NumberFormat.getNumberInstance(Locale.US).parse(value)
                return NumberFormat.getNumberInstance(Locale.US).format(number.toLong())
            } else {
                return ""
            }
        }
    }

    private fun updateView() {
        view.updateView(updateformat(model.getValue()), model.getDotValue())

    }
}