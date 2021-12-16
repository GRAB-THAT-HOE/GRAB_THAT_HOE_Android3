package kr.co.moreversal.grapthathoe.network.request

import androidx.lifecycle.MutableLiveData

data class PostRequest(
    val title : String,
    val mainlocation : String,
    val sublocation : String,
    val explanation : String,
    val salary : Int,
    val additionalExplantion : String,
    val isDisable : Boolean,
    val isForeign : Boolean,
    val giveRoomAndBoard : Boolean,
    val giveSnack : Boolean,
    val startDateYear : Int,
    val startDateMonth : Int,
    val startDateDay : Int,
    val endDateYear : Int,
    val endDateMonth : Int,
    val endDateDay : Int,
    val startTime : Int,
    val endTime : Int,
    val breakTime : Int,
    val img : String
)
