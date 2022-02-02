package com.example.youtubetestapplication

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.example.youtubetestapplication.databinding.ViewStoryBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class AlertSheetView : LinearLayout {
    private lateinit var binding: ViewStoryBottomSheetBinding
    private lateinit var behavior: BottomSheetBehavior<View>

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        initView(context)
    }

    private fun initView(context: Context) {
        binding = ViewStoryBottomSheetBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
        val persistentBottomSheet = binding.bottomsheet
        behavior = BottomSheetBehavior.from(persistentBottomSheet)
        behavior.isFitToContents = false
        behavior.peekHeight = 52
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        behavior.addBottomSheetCallback (object : BottomSheetBehavior.BottomSheetCallback() {
            @SuppressLint("SwitchIntDef")
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
    }

    fun setStoryInfo() {
        setButton()
        setContent()
        setLikeShareVisibility(true)
    }

    private fun setButton() {
        val multipleButtons = Button(context)
        multipleButtons.text = "ButtonText"
        multipleButtons.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        val view = binding.viewStorySheetTopContentLayout.peekButtons
        view.removeAllViews()
        view.addView(multipleButtons)
    }

    private fun setContent() {
        binding.ownHoldings.text = context.getString(R.string.stories_holdings_num, "3", "Automobile")
    }

    private fun setLikeShareVisibility(isVisible: Boolean) {
        binding.likeshareLayout.likeShare.visibility = if(isVisible) View.VISIBLE else View.GONE
    }
}