package kr.co.moreversal.grapthathoe.network.response

data class PostResponse(
    val status : Int
)

data class PostsResponse(
    val Posts : List<posts>
)

data class posts(
    val id : Int,
    val img : String,
    val title : String,
    val subExplanation: String
)
