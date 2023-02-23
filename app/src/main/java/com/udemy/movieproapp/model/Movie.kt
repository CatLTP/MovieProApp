package com.udemy.movieproapp.model

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.udemy.movieproapp.BR
import javax.annotation.Generated

@BindingAdapter("posterPath")
fun loadImage(imageView: ImageView, imageURL : String) {
    val imagePath = "https://image.tmdb.org/t/p/w500$imageURL"
    Glide.with(imageView.context)
        .load(imagePath)
        .into(imageView)
}


@Generated("jsonschema2pojo")
class Movie(
    posterPath : String? = null,
    adult : Boolean? = null,
    overview: String? = null,
    releaseDate: String? = null,
    genreIds: List<Int>? = null,
    id: Int? = null,
    originalTitle: String? = null,
    originalLanguage: String? = null,
    title: String? = null,
    backdropPath: String? = null,
    popularity: Double? = null,
    voteCount: Int? = null,
    video: Boolean? = null,
    voteAverage: Double? = null
) : BaseObservable(), Parcelable {



    constructor(parcel: Parcel) : this() {
        voteCount = parcel.readValue(Int::class.java.classLoader) as Int?
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        video = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        voteAverage = parcel.readValue(Double::class.java.classLoader) as Double?
        title = parcel.readValue(String::class.java.classLoader) as String?
        popularity = parcel.readValue(Double::class.java.classLoader) as Double?
        posterPath = parcel.readValue(String::class.java.classLoader) as String?
        originalLanguage = parcel.readValue(String::class.java.classLoader) as String?
        originalTitle = parcel.readValue(String::class.java.classLoader) as String?
        // this.genreIds?.let { parcel.readList(it,Int::class.java.classLoader) }
        backdropPath = parcel.readValue(String::class.java.classLoader) as String?
        adult = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        overview = parcel.readValue(String::class.java.classLoader) as String?
        releaseDate = parcel.readValue(String::class.java.classLoader) as String?

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(voteCount)
        parcel.writeValue(id)
        parcel.writeValue(video)
        parcel.writeValue(voteAverage)
        //parcel.writeValue(genreIds)
        parcel.writeValue(title)
        parcel.writeValue(popularity)
        parcel.writeValue(posterPath)
        parcel.writeValue(originalLanguage)
        parcel.writeValue(originalTitle)
        parcel.writeValue(backdropPath)
        parcel.writeValue(adult)
        parcel.writeValue(overview)
        parcel.writeValue(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
            override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }


    @SerializedName("poster_path")
    @Bindable
    var posterPath: String? = posterPath
        set(value) {
            field = value
            notifyPropertyChanged(BR.posterPath)
        }

    @SerializedName("adult")
    @Bindable
    var adult: Boolean? = adult
        set(value) {
            field = value
            notifyPropertyChanged(BR.adult)
        }

    @SerializedName("overview")
    @Bindable
    var overview: String? = overview
        set(value) {
            field = value
            notifyPropertyChanged(BR.overview)
        }

    @SerializedName("release_date")
    @Bindable
    var releaseDate: String? = releaseDate
        set(value) {
            field = value
            notifyPropertyChanged(BR.releaseDate)
        }

    @SerializedName("genre_ids")
    @Bindable
    var genreIds: List<Int>? = genreIds
        set(value) {
            field = value
            notifyPropertyChanged(BR.genreIds)
        }

    @SerializedName("id")
    @Bindable
    var id: Int? = id
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @SerializedName("original_title")
    @Bindable
    var originalTitle: String? = originalTitle
        set(value) {
            field = value
            notifyPropertyChanged(BR.originalTitle)
        }

    @SerializedName("original_language")
    @Bindable
    var originalLanguage: String? = originalLanguage
        set(value) {
            field = value
            notifyPropertyChanged(BR.originalLanguage)
        }

    @SerializedName("title")
    @Bindable
    var title: String? = title
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @SerializedName("backdrop_path")
    @Bindable
    var backdropPath: String? = backdropPath
        set(value) {
            field = value
            notifyPropertyChanged(BR.backdropPath)
        }

    @SerializedName("popularity")
    @Bindable
    var popularity: Double? = popularity
        set(value) {
            field = value
            notifyPropertyChanged(BR.popularity)
        }

    @SerializedName("vote_count")
    @Bindable
    var voteCount: Int? = voteCount
        set(value) {
            field = value
            notifyPropertyChanged(BR.voteCount)
        }

    @SerializedName("video")
    @Bindable
    var video: Boolean? = video
        set(value) {
            field = value
            notifyPropertyChanged(BR.video)
        }

    @SerializedName("vote_average")
    @Bindable
    var voteAverage: Double? = voteAverage
        set(value) {
            field = value
            notifyPropertyChanged(BR.voteAverage)
        }

}