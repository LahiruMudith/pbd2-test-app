package org.example.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.app.model.ObdService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainController {
    @FXML private ComboBox<String> portComboBox;
    @FXML private TextArea outputArea;
    private ScheduledExecutorService scheduler;
    private boolean isLiveSpeedRunning = false;

    @FXML
    private Label lblSpeed;


    private ObdService obdService;

    @FXML
    public void initialize() {
        obdService = new ObdService();
        portComboBox.getItems().addAll(obdService.getAvailablePorts());
    }

    @FXML
    public void handleConnect() {
        String port = portComboBox.getValue();
        if (port != null) {
            boolean success = obdService.connect(port);
            outputArea.appendText(success ? "Connected to " + port + "\n" : "Connection failed.\n");
        }
    }

    @FXML
    public void handleReadRPM() {
        String rpm = obdService.getRPM();
        outputArea.appendText("RPM: " + rpm + "\n");
    }

    @FXML
    public void handleReadCoolant() {
        String temp = obdService.getCoolantTemp();
        outputArea.appendText("Coolant Temp: " + temp + "\n");
    }

    @FXML
    public void handleLiveSpeed() {
        if (isLiveSpeedRunning) {
            stopLiveSpeed();
            outputArea.appendText("Stopped live speed updates.\n ");
            return;
        }

        if (obdService == null) {
            outputArea.appendText("Not connected to OBD.\n ");
            return;
        }

        isLiveSpeedRunning = true;
        scheduler = Executors.newSingleThreadScheduledExecutor();
        outputArea.appendText("Starting live speed updates...\n");

        scheduler.scheduleAtFixedRate(() -> {
            String speed = obdService.getSpeed();
            javafx.application.Platform.runLater(() -> lblSpeed.setText(speed));
        }, 0, 2, TimeUnit.SECONDS); // updates every 2 seconds
    }

    private void stopLiveSpeed() {
        isLiveSpeedRunning = false;
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
    }

    @FXML
    public void handleReadFuelLevel() {
        String fuelLevel = obdService.getFuelLevel();
        outputArea.appendText("Fuel Level: " + fuelLevel + "\n");
    }
}