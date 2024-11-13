package com.example.privatecurrency.domain.usecase

import com.example.privatecurrency.domain.repository.Repository

class UpdateUseCase(private val repository: Repository) {

    operator fun invoke() {
        repository.update()
    }
}