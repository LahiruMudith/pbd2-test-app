
# JavaFX OBD-II Diagnostic App 🚗📊

A JavaFX desktop application to read real-time vehicle data from an OBD-II adapter using serial communication. It connects to the vehicle via Bluetooth or USB and displays key engine diagnostics like RPM, speed, coolant temperature, and fuel level.

---

## 🧰 Features

- 🔌 Connect to available COM ports
- 🚗 Read live **RPM**
- 🌡️ Read **Engine Coolant Temperature**
- ⚡ Display **Vehicle Speed**
- ⛽ Display **Fuel Level**
- 🔁 Live speed updates (toggle on/off)

---

## 📁 Project Structure

```
src/
└── org.example.app
    ├── MainApp.java             # JavaFX application entry point
    ├── controller/
    │   └── MainController.java  # UI logic & event handling
    ├── model/
    │   └── ObdService.java      # Serial connection & OBD commands
    └── view/
        └── main.fxml            # JavaFX UI layout
```

---

## 🖥️ Requirements

- Java 17+ (recommended)
- JavaFX SDK
- RXTX library (for serial communication)
- [obd-java-api](https://github.com/pires/obd-java-api) library
- OBD-II adapter (Bluetooth/USB, ELM327 recommended)

---

## 🛠️ Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/LahiruMudith/pbd2-test-app.git
cd obd2-javafx-app
```

### 2. Add Maven Dependency for OBD Java API

```xml
<dependency>
  <groupId>com.github.pires</groupId>
  <artifactId>obd-java-api</artifactId>
  <version>1.0</version>
</dependency>
```

### 3. Add RXTX JARs and DLLs

- Add `RXTXcomm.jar` to your project's classpath.
- Place `rxtxSerial.dll` in:

```
C:\Windows\System32
```

---

## 🔧 How to Use

1. Launch the app
2. Select the COM port connected to your OBD-II device
3. Click **Connect**
4. Use buttons like:
   - "Read RPM"
   - "Read Coolant Temp"
   - "Read Speed"
   - "Read Fuel Level"
   - "Toggle Live Speed"

---

## 🧪 Supported Commands

| Command        | Description                     |
|----------------|---------------------------------|
| RPM            | Engine Revolutions per Minute   |
| Coolant Temp   | Temperature of engine coolant   |
| Speed          | Vehicle speed (km/h)            |
| Fuel Level     | Remaining fuel percentage       |

---

## 👨‍💻 Developer

**Lahiru Mudith**  
📍 Panadura Branch – GDSE71  
🛠️ JavaFX, OBD-II, Serial Communication

---

## ⚠️ Notes

- Make sure the vehicle **ignition is ON**
- Bluetooth pairing should be done via **Windows settings** before launching the app
- Port names like `COM3`, `COM5`, `COM9` should appear in the dropdown

---
