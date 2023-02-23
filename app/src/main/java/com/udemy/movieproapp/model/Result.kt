package com.udemy.movieproapp.model

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.Bindable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
class Result() : Parcelable {
    @SerializedName("page")
    var page: Int? = null

    @SerializedName("results")
    var results: List<Movie>? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    constructor(parcel: Parcel) : this() {
        page = parcel.readValue(Int::class.java.classLoader) as? Int
        this.results?.let { parcel.readList(it,Movie::class.java.classLoader) }
        totalResults = parcel.readValue(Int::class.java.classLoader) as? Int
        totalPages = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(page)
        parcel.writeValue(totalResults)
        parcel.writeValue(totalPages)
        parcel.writeList(results)
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }

}