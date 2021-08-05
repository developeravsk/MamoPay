package com.developerabhi.mamopay.model

import com.developerabhi.mamopay.interfaces.MyInterfaces

class MamoDataModel: MyInterfaces.MamoModel {
    private var value:String=""
    private var dotValue:String=""
    private var dotClickStatus=false
    private var cleared=false
    override fun valueUpdate(status: String) {
        this.value=status
    }

    override fun getValue(): String {
        return value
    }

    override fun dotClickStatusUpdate(status: Boolean) {
        dotClickStatus=status
    }

    override fun getdotClickStatus(): Boolean {
        return dotClickStatus
    }

    override fun clearedStatus(status: Boolean) {
        cleared=status
    }

    override fun getClearstatus(): Boolean {
        return cleared
    }

    override fun dotValueUpdate(value1: String) {
        dotValue=value1
    }

    override fun getDotValue(): String {
        return dotValue
    }
}