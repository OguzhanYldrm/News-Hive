package org.oym.newshive.domain.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Source(
    val id: String? = "",
    val name: String = ""
) : Parcelable