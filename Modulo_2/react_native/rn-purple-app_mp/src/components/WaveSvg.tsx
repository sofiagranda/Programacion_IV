import React from "react";
import Svg, { Path } from "react-native-svg";

export default function InventoryWave({ opacity = 0.25 }: { opacity?: number }) {
  return (
    <Svg width="100%" height="200" viewBox="0 0 1440 320" style={{ position: "absolute", top: 0 }}>
      <Path
        fill="#1e90ff"
        fillOpacity={opacity}
        d="M0,192L48,181.3C96,171,192,149,288,138.7C384,128,480,128,576,133.3C672,139,768,149,864,160C960,171,1056,181,1152,186.7C1248,192,1344,192,1392,192L1440,192L1440,0L1392,0C1344,0,1248,0,1152,0C1056,0,960,0,864,0C768,0,672,0,576,0C480,0,384,0,288,0C192,0,96,0,48,0L0,0Z"
      />
    </Svg>
  );
}
