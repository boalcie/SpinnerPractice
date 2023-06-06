package com.example.spinnerpractice

class ColorObject(var Name: String, var hex: String, var contrastHex: String) {
    val hexHash : String = "#$hex"
    val contrastHexHash : String = "#$contrastHex"
}