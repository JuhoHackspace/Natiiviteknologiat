package com.example.bmi_view_model.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _heightInput = MutableLiveData("")
    private var _weightInput = MutableLiveData("")
    private var _bmi = MutableLiveData(0.0f)
    val heightInput: LiveData<String> = _heightInput
    val weightInput: LiveData<String> = _weightInput
    val bmi: LiveData<Float> = _bmi

    fun updateHeightInput(newHeightInput: String) {
        _heightInput.value = newHeightInput
        calculateBMI()
    }

    fun updateWeightInput(newWeightInput: String) {
        _weightInput.value = newWeightInput
        calculateBMI()
    }

    private fun calculateBMI() {
        val height = _heightInput.value?.toFloatOrNull() ?: 0.0f
        val weight = weightInput.value?.toIntOrNull() ?: 0
        val bmi: Float = if (weight > 0 && height > 0) weight/ (height * height) else 0.0f
        _bmi.value  =  bmi
    }
}