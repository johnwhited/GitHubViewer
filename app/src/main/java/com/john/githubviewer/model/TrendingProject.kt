package com.john.githubviewer.model

import android.os.Parcel
import android.os.Parcelable

data class TrendingProject(
        val name: String? = null,
        val author: String? = null,
        val repository: String? = null,
        val description: String? = null) : Parcelable {

    constructor(source: Parcel) : this(source.readSerializable() as? String, source.readSerializable() as? String,
            source.readSerializable() as? String, source.readSerializable() as? String)

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeSerializable(name)
        dest?.writeSerializable(author)
        dest?.writeSerializable(repository)
        dest?.writeSerializable(description)
    }

    companion object {
        @JvmField
        @Suppress("unused")
        val CREATOR: Parcelable.Creator<TrendingProject> = object : Parcelable.Creator<TrendingProject> {
            override fun createFromParcel(source: Parcel): TrendingProject {
                return TrendingProject(source)
            }

            override fun newArray(size: Int): Array<TrendingProject?> {
                return arrayOfNulls(size)
            }
        }
    }
}
