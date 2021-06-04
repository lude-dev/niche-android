package com.implude.niche.data.mappers

interface Mapper<T, R> {
    fun map(data: T): R
}

val mappingFailedException = IllegalStateException("Mapping failed")
