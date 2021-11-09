package com.reactnativewaveformseekbar

import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.common.SystemClock
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerModule
import com.facebook.react.uimanager.annotations.ReactProp
import com.masoudss.lib.SeekBarOnProgressChanged
import com.masoudss.lib.WaveformSeekBar
import com.masoudss.lib.utils.Utils
import com.masoudss.lib.utils.WaveGravity


class WaveformSeekBarViewManager : SimpleViewManager<WaveformSeekBarView>() {
  override fun getName(): String {
    return REACT_CLASS
  }

  public override fun createViewInstance(reactContext: ThemedReactContext): WaveformSeekBarView {
    val view = WaveformSeekBarView(reactContext)
    view.onProgressChanged = object : SeekBarOnProgressChanged {
      override fun onProgressChanged(
        waveformSeekBar: WaveformSeekBar,
        progress: Float,
        fromUser: Boolean
      ) {
        if (progress in 0f..100f) {
          reactContext
            .getNativeModule(UIManagerModule::class.java).eventDispatcher
            .dispatchEvent(
              OnChangeEvent(view.id, SystemClock.nanoTime(), progress, fromUser)
            )
        }
      }
    }
    return view
  }

  @ReactProp(name = "data")
  fun setData(view: WaveformSeekBarView, data: ReadableArray?) {
    data?.let {
      if (it.size() > 0) {
        val list = it.toArrayList() as ArrayList<Int>
        view.setSampleFrom(list.toIntArray())
      }
    }
  }

  @ReactProp(name = "progress", defaultFloat = 0f)
  fun setProgress(view: WaveformSeekBarView, input: Float) {
    input?.let {
      view.progress = it
    }
  }

  @ReactProp(name = "maxProgress", defaultFloat = 100f)
  fun setMaxProgress(view: WaveformSeekBarView, input: Float) {
    input?.let {
      view.maxProgress = it
    }
  }

  @ReactProp(name = "visibleProgress", defaultFloat = 50f)
  fun setVisibleProgress(view: WaveformSeekBarView, input: Float) {
    input?.let {
      view.visibleProgress = it
    }
  }

  @ReactProp(name = "waveWidth", defaultInt = 10)
  fun setWidth(view: WaveformSeekBarView, input: Int) {
    input?.let {
      view.waveWidth = Utils.dp(view.context, input)
    }
  }

  @ReactProp(name = "gap", defaultInt = 5)
  fun setGap(view: WaveformSeekBarView, input: Int) {
    input?.let {
      view.waveGap = Utils.dp(view.context, input)
    }
  }

  @ReactProp(name = "minHeight", defaultInt = 20)
  fun setMinHeight(view: WaveformSeekBarView, input: Int) {
    input?.let {
      view.waveGap = Utils.dp(view.context, input)
    }
  }

  @ReactProp(name = "radius", defaultInt = 5)
  fun setRadius(view: WaveformSeekBarView, input: Int) {
    input?.let {
      view.waveCornerRadius = Utils.dp(view.context, input)
    }
  }

  @ReactProp(name = "backgroundColor", defaultInt = 0)
  fun setWaveBackgroundColor(view: WaveformSeekBarView, input: Int) {
    input?.let {
      view.waveBackgroundColor = it
    }
  }

  @ReactProp(name = "progressColor", defaultInt = 0)
  fun setWaveProgressColor(view: WaveformSeekBarView, input: Int) {
    input?.let {
      view.waveProgressColor = it
    }
  }

  @ReactProp(name = "gravity")
  fun setGravity(view: WaveformSeekBarView, input: String) {
    input?.let {
      view.waveGravity = when (it) {
        "top" -> WaveGravity.TOP
        "bottom" -> WaveGravity.BOTTOM
        else -> WaveGravity.CENTER
      }
    }
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
    return MapBuilder.builder<String, Any>()
      .put(
        OnChangeEvent.EVENT_NAME,
        MapBuilder.of("registrationName", OnChangeEvent.EVENT_NAME)
      )
      .build()
  }

  companion object {
    const val REACT_CLASS = "WaveformSeekBarView"
  }
}
