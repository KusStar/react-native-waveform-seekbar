package com.reactnativewaveformseekbar

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

import com.facebook.react.uimanager.events.RCTEventEmitter

class OnChangeEvent(
  viewTag: Int,
  timestampMs: Long,
  private val progress: Float,
  private val fromUser: Boolean
) :
  Event<OnChangeEvent>(viewTag) {
  override fun dispatch(rctEventEmitter: RCTEventEmitter) {
    val data: WritableMap = Arguments.createMap()
    data.putDouble("progress", progress.toDouble())
    data.putBoolean("fromUser", fromUser)
    rctEventEmitter.receiveEvent(viewTag, eventName, data)
  }

  companion object {
    const val EVENT_NAME = "onChange"
  }

  override fun getEventName(): String {
    return EVENT_NAME
  }
}
