package com.example.cc17_3f_bravojrs_act5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.example.cc17_3f_bravojrs_act5.R
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val artworks = intArrayOf(R.drawable.top_10_irises_jpg,
                                      R.drawable.top_12_wheat_field_with_cypresses_jpg,
                                      R.drawable.top_7_luncheon_of_the_boating_party_jpg,
                                      R.drawable.top_8_impression_sunrise_jpg,
                                      R.drawable.top_9_starry_night_over_the_rhone_jpg)
    val titles: Array<String>
        get() = arrayOf("Irises", "Wheat Field with Cypresses at the Haude Galline near Eygalieres", "Luncheon of the Boating Party",  "Impression Sunrise", "Starry Night over the Rhone")
    val authors = arrayOf("Vincent Van Gogh (1889)", "Vincent Van Gogh (1889)", "Pierre Auguste Renoir (1881)", "Claude Oscar Monet (1873)", "Vincent Van Gogh (1888)")

    var currentArtworkIndex = 0 // To track the current artwork

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val artworkView: ImageView = findViewById(R.id.artworks)
        val titleView: TextView = findViewById(R.id.art_title)
        val authorView: TextView = findViewById(R.id.art_author)
        val nextButton: Button = findViewById(R.id.next_button)
        val prevButton: Button = findViewById(R.id.prev_button)

        updateArtwork(artworkView, titleView, authorView)

        nextButton.setOnClickListener {
            currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
            updateArtwork(artworkView, titleView, authorView)
        }


        prevButton.setOnClickListener {
            currentArtworkIndex = if (currentArtworkIndex > 0) currentArtworkIndex - 1 else artworks.size - 1
            updateArtwork(artworkView, titleView, authorView)
        }
    }

    private fun updateArtwork(artworkView: ImageView, titleView: TextView, authorView: TextView) {
        artworkView.setImageResource(artworks[currentArtworkIndex])
        titleView.text = titles[currentArtworkIndex]
        authorView.text = authors[currentArtworkIndex]
    }
}
