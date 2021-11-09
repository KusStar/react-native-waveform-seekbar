# react-native-waveform-seekbar

A <WaveformSeekBar /> component for React-Native

## Installation

```sh
npm install react-native-waveform-seekbar
```

## Usage

```js
import WaveformSeekBar from "react-native-waveform-seekbar";

// ./example/src/App.tsx
<WaveformSeekBar
  style={styles.box}
  data={data}
  backgroundColor="#fff"
  progressColor={'yellow'}
  onChange={(e) => console.log(e.nativeEvent)}
/>
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
