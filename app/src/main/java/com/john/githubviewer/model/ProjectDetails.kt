package com.john.githubviewer.model

import android.os.Parcel
import android.os.Parcelable

data class ProjectDetails (
        val repositoryName: String? = null,
        val description: String? = null,
        val languages: String? = null,
        val watchers: Long? = null,
        val openIssues: Long? = null,
        val createdAt: String? = null,
        val updatedAt: String? = null,
        val cloneUrl: String? = null) : Parcelable {

    constructor(source: Parcel) : this(source.readSerializable() as? String, source.readSerializable() as? String,
            source.readSerializable() as? String, source.readSerializable() as? Long, source.readSerializable() as? Long,
            source.readSerializable() as? String, source.readSerializable() as? String, source.readSerializable() as? String)

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeSerializable(repositoryName)
        dest?.writeSerializable(description)
        dest?.writeSerializable(languages)
        dest?.writeSerializable(watchers)
        dest?.writeSerializable(openIssues)
        dest?.writeSerializable(createdAt)
        dest?.writeSerializable(updatedAt)
        dest?.writeSerializable(cloneUrl)
    }

    companion object {
        @Suppress("unused")
        @JvmField
        val CREATOR: Parcelable.Creator<ProjectDetails> = object : Parcelable.Creator<ProjectDetails> {
            override fun createFromParcel(source: Parcel): ProjectDetails {
                return ProjectDetails(source)
            }

            override fun newArray(size: Int): Array<ProjectDetails?> {
                return arrayOfNulls(size)
            }
        }
    }
}
