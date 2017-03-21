package org.jboss.test.drools.cep.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jboss.test.drools.cep.demo.model.ClockType;
import org.jboss.test.drools.cep.demo.model.Fact;
import org.jboss.test.drools.cep.demo.model.Shift;
import org.jboss.test.drools.cep.demo.model.Staff;
import org.jboss.test.drools.cep.demo.model.TimeRecordEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FactsLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(FactsLoader.class);

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd:HHmmssSSS");
	
	public static List<Fact> loadEvents(File eventsFile) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(eventsFile));
		} catch (FileNotFoundException fnfe) {
			String message = "File not found.";
			LOGGER.error(message, fnfe);
			throw new IllegalArgumentException(message, fnfe);
		}
		return loadEvents(br);
	}
	
	public static List<Fact> loadEvents(InputStream eventsInputStream) {
		BufferedReader br = new BufferedReader(new InputStreamReader(eventsInputStream));
		return loadEvents(br);
		
	}

	private static List<Fact> loadEvents(BufferedReader br) {

		List<Fact> eventList = new ArrayList<Fact>();
		try {
			String nextLine;
			while ((nextLine = br.readLine()) != null) {
				if (!nextLine.startsWith("#")) {
					Fact event = readEvent(nextLine);
					if (event != null) {
						eventList.add(event);
					}
					
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Got an exception while reading events.", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					// Swallowing exception, not much we can do here.
					LOGGER.error("Unable to close reader.", ioe);
				}
			}
		}
		return eventList;
	}

	private static Fact readEvent(String line) {
		String[] eventData = line.split(",");

		Fact event = null;
		try {
			if(eventData.length == 3) {
				Staff staff = new Staff(eventData[0].trim());
				event = new TimeRecordEvent(staff, ClockType.valueOf(eventData[1].trim()), DATE_FORMAT.parse(eventData[2].trim()));
			}
			
			if(eventData.length == 4) {
				event = new Shift(eventData[0].trim(),eventData[1].trim(),eventData[2].trim(),eventData[3].trim());
			} 
			
		} catch (NumberFormatException nfe) {
			LOGGER.error("Error parsing line: " + line, nfe);
		} catch (ParseException pe) {
			LOGGER.error("Error parsing line: " + line, pe);
		}
		return event;

	}
	
}
