package com.implude.niche.data.mappers

interface Mapper<T, R> {
    fun map(data: T): R
}