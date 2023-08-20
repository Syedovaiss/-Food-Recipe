package com.ovais.foodfusion.common.ui

interface Mapper<P, R> {
    fun map(param: P): R
}