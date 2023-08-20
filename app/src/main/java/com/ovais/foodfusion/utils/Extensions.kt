package com.ovais.foodfusion.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ovais.foodfusion.network.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


fun String?.default(default: String? = null) = this ?: default ?: EMPTY_STRING



fun ViewModel.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job = viewModelScope.launch(context, start, block)


fun <T, R> ViewModel.transformState(
    invocation: suspend () -> State<T>,
    onCompleted: (a: T) -> R,
    onFailed: ((String) -> R)? = null,
) {
    launch {
        transform(
            invocation,
            onCompleted,
            onFailed = {
                onFailed?.invoke(it)
            }
        )
    }
}

private fun <T, R> transform(
    invocation: State<T>,
    onCompleted: (a: T) -> R,
    onFailed: (String) -> R,
): R {
    return when (invocation) {
        is State.Completed -> onCompleted(invocation.data)
        is State.Failed -> onFailed(invocation.data)
    }
}
private suspend fun <T, R> transform(
    invocation: suspend () -> State<T>,
    onCompleted: (data: T) -> R,
    onFailed: (String) -> R,
): R {
    return transform(
        invocation(),
        onCompleted = onCompleted,
        onFailed = onFailed
    )
}
