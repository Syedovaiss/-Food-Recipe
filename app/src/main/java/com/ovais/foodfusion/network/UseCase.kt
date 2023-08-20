package com.ovais.foodfusion.network

import androidx.lifecycle.ViewModel
import com.ovais.foodfusion.utils.launch

interface ParameterizedUseCase<P, R> {
    operator fun invoke(parameters: P): R
}

interface SuspendParameterizedUseCase<P, R> {
    suspend operator fun invoke(parameters: P): R
}


interface UseCase<R> {
    operator fun invoke(): R
}

interface SuspendUseCase<R> {
    suspend operator fun invoke(): R
}


interface StateParameterizedUseCase<P, T> : SuspendParameterizedUseCase<P, State<T>>

interface StateUseCase<T> : SuspendUseCase<State<T>>


sealed interface State<out T> {
    data class Completed<T>(val data: T) : State<T>
    data class Failed(val data: String) : State<Nothing>
}
