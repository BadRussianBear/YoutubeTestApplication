package com.example.youtubetestapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.youtubetestapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class MainActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.sheet.setStoryInfo()
        binding.videoStory.initialize(
            "YOUTUBE_KEY_FOR_DEVELOPMENT",
            this
        )
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        youTubePlayer: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        if (!wasRestored) {
            youTubePlayer?.loadVideo("IenuyqISKok")
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        result: YouTubeInitializationResult?
    ) {
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}