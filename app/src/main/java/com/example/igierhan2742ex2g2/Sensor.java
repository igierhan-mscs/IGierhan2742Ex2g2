package com.example.igierhan2742ex2g2;

import java.util.ArrayList;
import java.util.Objects;

public class Sensor {
    private int sensorId;
    private int roomId;
    private int sensorTypeId;
    private String description;
//    private Room room;
//    private SensorType sensorType;
    private ArrayList<SensorReading> sensorReadings;

    public Sensor(int sensorId, int roomId, int sensorTypeId, String description) {
        this.sensorId = sensorId;
        this.roomId = roomId;
        this.sensorTypeId = sensorTypeId;
        this.description = description;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(int sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public domain.Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(domain.Room room) {
//        this.room = room;
//    }
//
//    public domain.SensorType getSensorType() {
//        return sensorType;
//    }
//
//    public void setSensorType(domain.SensorType sensorType) {
//        this.sensorType = sensorType;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sensor)) return false;
        Sensor sensor = (Sensor) o;
        return sensorId == sensor.sensorId &&
                roomId == sensor.roomId &&
                sensorTypeId == sensor.sensorTypeId &&
                Objects.equals(description, sensor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, roomId, sensorTypeId, description);
    }

    @Override
    public String toString() {
        return Integer.toString(sensorId) +
                ", roomId=" + roomId +
                ", sensorTypeId=" + sensorTypeId +
                ", " + description;
    }

    public ArrayList<SensorReading> getSensorReadings() {
        return sensorReadings;
    }

    public void setSensorReadings(ArrayList<SensorReading> sensorReadings) {
        this.sensorReadings = sensorReadings;
    }

    public int findMinReadingIndex() {

        int minIndex = 0;
        for (int i = 1; i < sensorReadings.size(); i++) {
            if (sensorReadings.get(i).getValue() < sensorReadings.get(minIndex).getValue()) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int findMinReadingIndex(int startIndex, int endIndex) {

        int minIndex = startIndex;
        if (startIndex > 0 && endIndex < (sensorReadings.size() - 1) && !(startIndex >= endIndex)) {
            for (int i = minIndex + 1; i < endIndex; i++) {
                if (sensorReadings.get(i).getValue() < sensorReadings.get(minIndex).getValue()) {
                    minIndex = i;
                }
            }
            return minIndex;
        }
        throw new IndexOutOfBoundsException("Index out of bounds: 0 - 117");
    }

    public int findMaxReadingIndex() {

        int maxIndex = 0;
        for (int i = 1; i < sensorReadings.size(); i++) {
            if (sensorReadings.get(i).getValue() > sensorReadings.get(maxIndex).getValue()) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public int findMaxReadingIndex(int startIndex, int endIndex) {

        int maxIndex = startIndex;
        if (startIndex > 0 && endIndex < (sensorReadings.size() - 1) && !(startIndex >= endIndex)) {
            for (int i = maxIndex; i < endIndex; i++) {
                if (sensorReadings.get(i).getValue() > sensorReadings.get(maxIndex).getValue()) {
                    maxIndex = i;
                }
            }

            return maxIndex;
        }
        throw new IndexOutOfBoundsException("Index out of bounds: 0 - 117");
    }

    public int findNextCycleMaxIndex(int startIndex) {
        SensorReading rMax = this.sensorReadings.get(startIndex);
        int i = startIndex + 1;

        for ( ; i < this.sensorReadings.size(); i++) {
            if (rMax.getValue() < this.sensorReadings.get(i).getValue())
                rMax = this.sensorReadings.get(i);
            else
                break;
        }
        return i -1;
    }

    public int findNextCycleMinIndex(int startIndex) {
        SensorReading rMin = this.sensorReadings.get(startIndex);
        int i = startIndex + 1;

        for ( ; i < this.sensorReadings.size(); i++) {
            if (rMin.getValue() > this.sensorReadings.get(i).getValue())
                rMin = this.sensorReadings.get(i);
            else
                break;
        }
        return i -1;
    }

    public SensorReading getSensorReading(int index) {
        return this.sensorReadings.get(index);
    }
}

