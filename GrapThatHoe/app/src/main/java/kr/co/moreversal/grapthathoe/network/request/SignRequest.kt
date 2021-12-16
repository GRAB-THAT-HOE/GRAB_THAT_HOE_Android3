package kr.co.moreversal.grapthathoe.network.request

data class ConfirmRequest(
    val confirmationcode: Int
)

data class JoinRequest(
    val name: String,
    val phone: Int,
    val introduction: String,
    val permission: Int,
    val sublocation: String,
    val mainlocation: String
)

data class LoginRequest(
    val phone : Int
)
