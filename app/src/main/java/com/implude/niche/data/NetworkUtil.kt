package com.implude.niche.data

import io.reactivex.rxjava3.core.Single

fun <T> safeSingleCall(networkCall: () -> T): Single<T> = Single.create {
    try {
        it.onSuccess(networkCall())
    } catch (t: Throwable) {
        it.onError(t)
    }
}

val operationFailedException =
    IllegalStateException("Parsing response of GraphQL operation execution failed")