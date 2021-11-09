import React from 'react';
import {
  StyleSheet,
  ViewStyle,
  StyleProp,
  processColor,
  NativeSyntheticEvent,
} from 'react-native';
import NativeWaveformSeekBar from './NativeWaveformSeekBar';

export type OnChangeEvent = (
  e: NativeSyntheticEvent<{ progress: number; fromUser: boolean }>
) => void;

export type WaveformSeekBarProps = {
  style: StyleProp<ViewStyle>;
  data: number[];
  progress?: number;
  maxProgress?: number;
  visibleProgress?: number;
  waveWidth?: number;
  gap?: number;
  minHeight?: number;
  radius?: number;
  backgroundColor?: number;
  progressColor?: number;
  gravity?: 'top' | 'center' | 'bottom';
  onChange?: OnChangeEvent;
};

export interface Props
  extends Omit<WaveformSeekBarProps, 'backgroundColor' | 'progressColor'> {
  backgroundColor?: string;
  progressColor?: string;
}

export const WaveformSeekBar: React.FC<Props> = ({
  style,
  data,
  progress,
  maxProgress,
  visibleProgress,
  waveWidth,
  gap,
  minHeight,
  radius,
  backgroundColor,
  progressColor,
  gravity = 'center',
  onChange,
}) => {
  return (
    <NativeWaveformSeekBar
      style={[styles.defaultStyle, style]}
      data={data}
      progress={progress}
      maxProgress={maxProgress}
      visibleProgress={visibleProgress}
      waveWidth={waveWidth}
      gap={gap}
      minHeight={minHeight}
      radius={radius}
      backgroundColor={processColor(backgroundColor)}
      progressColor={processColor(progressColor)}
      gravity={gravity}
      onChange={onChange}
    />
  );
};

const styles = StyleSheet.create({
  defaultStyle: {
    width: '100%',
    height: '100%',
  },
});
