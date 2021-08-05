package com.developerabhi.mamopay.model

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MamoDataModelTest {
    private val mamomodel:MamoDataModel= MamoDataModel()

    @Test
    fun valueUpdate(){
        mamomodel.valueUpdate("112")
        assertEquals("112",mamomodel.getValue())
    }
    @Test
    fun getValue() {
        val value="113"
        mamomodel.valueUpdate("113")
        assertEquals("113", mamomodel.getValue())
    }


    @Test
    fun getdotClickStatus() {
        val status=false;
        assertEquals(status,mamomodel.getdotClickStatus())
    }

    @Test
    fun clearedStatus() {
        mamomodel.clearedStatus(true)
        assertEquals(true,mamomodel.getClearstatus())
    }


    @Test
    fun getClearstatus() {
        val cleared=true
        mamomodel.clearedStatus(true)
        assertEquals(cleared,mamomodel.getClearstatus())
    }

    @Test
    fun dotValueUpdate() {
        mamomodel.valueUpdate("12")
        assertEquals("12",mamomodel.getValue())
    }

    @Test
    fun getDotValue() {
        val value="01"
        mamomodel.dotValueUpdate("11")
        assertEquals("11", mamomodel.getDotValue())
    }
}