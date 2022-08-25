package com.pedromoura.itau

import android.os.Parcelable
import com.pedromoura.itau.data.model.Owner
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PullRequest(
    val user: Owner,
    val title: String,
    val created_at: String,
    val body: String
) : Parcelable
