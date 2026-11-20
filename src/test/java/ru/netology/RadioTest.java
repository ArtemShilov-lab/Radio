
package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();

        radio.next();

        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromLastStationToFirst() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToPreviousStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromFirstStationToLast() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldSetStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio();

        radio.setCurrentStation(-1);

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveNine() {
        Radio radio = new Radio();

        radio.setCurrentStation(10);

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();

        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();

        radio.increaseVolume();
        radio.increaseVolume();

        radio.decreaseVolume();

        assertEquals(2, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowZero() {
        Radio radio = new Radio();

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    void shouldSet10StationsByDefault() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);

        assertEquals(9, radio.getCurrentStation());

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }
    @Test
    void shouldSet5Stations() {
        Radio radio = new Radio(5);

        radio.setCurrentStation(4);

        assertEquals(4, radio.getCurrentStation());

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }
    @Test
    void shouldSwitchFromFirstStationToLastForFiveStations() {
        Radio radio = new Radio(5);

        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }
    @Test
    void shouldSwitchFromLastStationToFirstFor20Stations() {
        Radio radio = new Radio(20);

        radio.setCurrentStation(19);

        assertEquals(19, radio.getCurrentStation());

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }
    @Test
    void shouldSwitchFromFirstStationToLastFor20Stations() {
        Radio radio = new Radio(20);

        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(19, radio.getCurrentStation());
    }
    @Test
    void shouldNotSetStationEqualToStationsCount() {
        Radio radio = new Radio(5);

        radio.setCurrentStation(5);

        assertEquals(0, radio.getCurrentStation());
    }
    @Test
    void shouldNotSetNegativeStationForFiveStations() {
        Radio radio = new Radio(5);

        radio.setCurrentStation(-1);

        assertEquals(0, radio.getCurrentStation());
    }
    @Test
    void shouldNotSetStationEqualToStationsCountFor20Stations() {
        Radio radio = new Radio(20);

        radio.setCurrentStation(20);

        assertEquals(0, radio.getCurrentStation());
    }
}
