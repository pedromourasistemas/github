package com.pedromoura.itau.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryResponse(
    val items: List<ItemsResponse>
) : Parcelable

@Parcelize
data class ItemsResponse(
    val name: String,
    val full_name: String,
    val description: String,
    val owner: OwnerResponse,
    val stargazers_count: Long,
    val forks_count: Long
) : Parcelable

@Parcelize
data class OwnerResponse(
    val login: String,
    val avatar_url: String
) : Parcelable
