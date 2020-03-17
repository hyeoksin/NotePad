package com.khs.noteexample.model

import android.os.Parcel
import android.os.Parcelable

data class NoteModel(
    var id: Int? = null,
    var title: String? = null,
    var content: String? = null
) : Parcelable {

    constructor(title: String, content: String) : this() {
        this.title = title
        this.content = content
    }

    constructor(id:Int,title:String,content:String):this(){
        this.id = id
        this.title = title
        this.content = content
    }

    constructor(source: Parcel) : this(
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(id)
        writeString(title)
        writeString(content)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NoteModel> = object : Parcelable.Creator<NoteModel> {
            override fun createFromParcel(source: Parcel): NoteModel = NoteModel(source)
            override fun newArray(size: Int): Array<NoteModel?> = arrayOfNulls(size)
        }
    }
}
