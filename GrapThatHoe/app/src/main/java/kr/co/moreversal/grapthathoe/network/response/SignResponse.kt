package kr.co.moreversal.grapthathoe.network.response

data class PhoneResponse(
    val isExist : Boolean
)

data class ConfirmResponse(
    val status : Int,
    val message : String
)

data class JoinResponse(
    val status : Int,
    val message : String
)

data class LoginResponse(
    val token : String
)
