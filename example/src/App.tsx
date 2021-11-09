import React, { useState } from 'react';

import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  StatusBar,
} from 'react-native';
import { WaveformSeekBar } from 'react-native-waveform-seekbar';

const randInt = (min = 0, max = 100) => {
  return Math.floor(Math.random() * (max - min + 1)) + min;
};

const genData = (n: number, min = 0, max = 100) =>
  Array.from({ length: n }, (_) => randInt(min, max));

const MAX = 100;

export default function App() {
  const [data, setData] = useState<number[]>(genData(randInt(0, MAX)));

  const changeWaves = () => {
    setData(genData(randInt(0, MAX)));
  };

  return (
    <View style={styles.container}>
      <StatusBar translucent backgroundColor="transparent" />
      <WaveformSeekBar
        style={styles.box}
        data={data}
        backgroundColor="#fff"
        progressColor={'yellow'}
        onChange={(e) => console.log(e.nativeEvent)}
      />
      <TouchableOpacity onPress={changeWaves} style={styles.btn}>
        <Text style={styles.text}>Regenerating waves data</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#000',
    padding: 30,
  },
  text: {
    color: '#fff',
    fontSize: 20,
  },
  btn: {
    borderWidth: 1,
    borderColor: '#fff',
    borderRadius: 50,
    padding: 20,
    marginTop: 100,
  },
  box: {
    height: 100,
  },
});
