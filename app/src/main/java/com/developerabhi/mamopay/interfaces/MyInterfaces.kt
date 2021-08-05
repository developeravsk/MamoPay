package com.developerabhi.mamopay.interfaces

interface MyInterfaces {
    interface MamoModel{
        fun valueUpdate(status: String)
        fun getValue():String
        fun dotClickStatusUpdate(status: Boolean)
        fun getdotClickStatus():Boolean
        fun clearedStatus(status:Boolean)
        fun getClearstatus():Boolean
        fun dotValueUpdate(value:String)
        fun getDotValue():String
    }
    interface MamoPresenter{
        fun dotClick()
        fun digitClick(text: String)
        fun chardelete()
    }
    interface MamoView {
        fun initView()
        fun updateView(result: String,result1:String)
    }
}