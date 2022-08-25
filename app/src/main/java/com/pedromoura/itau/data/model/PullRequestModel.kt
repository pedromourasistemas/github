package com.pedromoura.itau.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PullRequestModel(
    val title: String,
    val body: String?,
    val user: Owner
) : Parcelable
