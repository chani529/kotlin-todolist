package com.example.todo.models

data class Station(
    var stationId:Int,
    var stationName:String,
    var addressRoad: String,
    var addressRegion:String,
    var addressDetail:String,
    var s3Url: String
)