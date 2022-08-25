package com.pedromoura.itau.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryModel(
    val name: String,
    val full_name: String,
    val description: String,
    val owner: Owner,
    val stargazers_count: Long,
    val forks_count: Long
) : Parcelable

@Parcelize
data class Owner(
    val login: String,
    val avatar_url: String
) : Parcelable
