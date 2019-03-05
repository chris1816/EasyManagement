package com.example.cln62.easymanagement.adapter

interface BindableAdapter<T> {
    fun setData(items: List<T>)
    fun changedPositions(positions: Int)
}