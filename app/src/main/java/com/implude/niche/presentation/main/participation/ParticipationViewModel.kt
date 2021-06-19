package com.implude.niche.presentation.main.participation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implude.niche.data.LocalDataStore
import com.implude.niche.domain.models.NeedFixReportModel
import com.implude.niche.domain.repositories.ParticipationRepository
import com.implude.niche.presentation.util.SingleLiveEvent

class ParticipationViewModel(
    private val localDataStore: LocalDataStore,
    private val participationRepository: ParticipationRepository,
) : ViewModel() {

    val nearFixReportsFetchFailedEvent = SingleLiveEvent<Unit>()

    private val _nearFixReports = MutableLiveData<List<NeedFixReportModel>>()
    val nearFixReports: LiveData<List<NeedFixReportModel>> = _nearFixReports

    fun fetchNearFixReports() {
        val (lat, lon) = localDataStore.location ?: return
        participationRepository.getNearFixReports(lat, lon).doOnSuccess {
            _nearFixReports.value = it
        }.doOnError {
            nearFixReportsFetchFailedEvent.call()
        }.subscribe()
    }
}
