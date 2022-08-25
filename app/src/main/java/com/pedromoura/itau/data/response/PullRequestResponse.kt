package com.pedromoura.itau.data.response

import android.os.Parcelable
import com.pedromoura.itau.data.model.Owner
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PullRequestResponse(
    val title: String,
    val body: String,
    val user: Owner
) : Parcelable