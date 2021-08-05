package com.developerabhi.mamopay.presenter

import com.developerabhi.mamopay.interfaces.MyInterfaces
import com.developerabhi.mamopay.model.MamoDataModel
import com.developerabhi.mamopay.view.MainActivity
import org.junit.Test

import org.junit.Assert.*

class MamoPayPresenterTest {

    private var model: MyInterfaces.MamoModel = MamoDataModel()


    @Test
    fun dotClick() {
        val dotClickStatus = false
        model.dotClickStatusUpdate(!dotClickStatus)
        assertEquals(true, model.getdotClickStatus())
    }

    @Test
    fun digitClick_for_numbers() {
        model.valueUpdate("111")
        model.dotClickStatusUpdate(false)
        if (model.getValue().length < 8) {
            model.valueUpdate(model.getValue() + "3")
            assertEquals("1113", model.getValue())
        } else {
            assertEquals(model.getValue(),model.getValue())
        }

    }

    @Test
    fun digitClick_for_decimal() {
        model.dotClickStatusUpdate(true)
        model.dotValueUpdate("1")
        if (model.getdotClickStatus() == true) {
            if (model.getDotValue().length < 2) {
                model.dotValueUpdate(model.getDotValue() + "2")
                assertEquals("12", model.getDotValue())
            } else
                assertEquals(model.getValue(), model.getValue())
        }
    }


    @Test
    fun chardelete_for_decimal() {
        model.dotValueUpdate("12")
        if (model.getdotClickStatus() == true) {
            if (model.getDotValue().length > 1) {
                model.dotValueUpdate(
                    model.getDotValue().substring(0, model.getDotValue().length - 1)
                )
                assertEquals("1",model.getDotValue())
            } else {
                model.dotClickStatusUpdate(false)
                model.dotValueUpdate("")
                assertEquals("",model.getDotValue())
            }
        }else{
            assertEquals(model.getDotValue(),model.getDotValue())
        }
    }

    @Test
    fun chardelete_for_number() {
        model.valueUpdate("12345")
        if (model.getdotClickStatus() == false) {
            if (model.getValue().length < 8) {
                model.valueUpdate(
                    model.getValue().substring(0, model.getValue().length - 1)
                )
                assertEquals("1234",model.getValue())
            } else {
                assertEquals(model.getValue(),model.getValue())
            }
        }else{
            assertEquals(model.getValue(),model.getValue())
        }
    }
}