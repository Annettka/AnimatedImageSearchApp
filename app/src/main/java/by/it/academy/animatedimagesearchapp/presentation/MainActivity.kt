package by.it.academy.animatedimagesearchapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.it.academy.animatedimagesearchapp.R
import by.it.academy.animatedimagesearchapp.presentation.galleryfragment.GalleryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, GalleryFragment())
                .commit()
        }
    }
}