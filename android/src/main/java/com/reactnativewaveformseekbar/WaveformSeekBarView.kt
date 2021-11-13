package com.reactnativewaveformseekbar

import android.content.Context
import com.masoudss.lib.WaveformSeekBar

class WaveformSeekBarView(context: Context) : WaveformSeekBar(context) {
  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    if (w >= 0 && h >= 0) {
      super.onSizeChanged(w, h, oldw, oldh)
    }
  }
}
