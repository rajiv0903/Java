package com.practice.java.designpattern.org.learning.pattern._02_observer.entry;

import com.practice.java.designpattern.org.learning.pattern._02_observer.weatherDisplay.CurrentConditionsDisplay;
import com.practice.java.designpattern.org.learning.pattern._02_observer.weatherDisplay.ForecastDisplay;
import com.practice.java.designpattern.org.learning.pattern._02_observer.weatherDisplay.HeatIndexDisplay;
import com.practice.java.designpattern.org.learning.pattern._02_observer.weatherDisplay.StatisticsDisplay;
import com.practice.java.designpattern.org.learning.pattern._02_observer.weatherSubject.WeatherSubjectData;

public class WeatherStationHeatIndex {

	public static void main(String[] args) {
		
		WeatherSubjectData weatherSubjectData = new WeatherSubjectData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherSubjectData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherSubjectData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherSubjectData);
		//added later- a new display unit
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherSubjectData);

		weatherSubjectData.setDataChanged(true);
		weatherSubjectData.setMeasurements(80, 65, 30.4f);
		weatherSubjectData.setMeasurements(82, 70, 29.2f);
		weatherSubjectData.setMeasurements(78, 90, 29.2f);
	}
}
