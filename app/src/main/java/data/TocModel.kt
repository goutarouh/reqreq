package data

data class TocModel(
    val title : String,
    val tocId : Int,
    val parentId : Int,
    val parentTitle : String
)