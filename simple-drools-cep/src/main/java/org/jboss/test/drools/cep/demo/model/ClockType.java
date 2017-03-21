package org.jboss.test.drools.cep.demo.model;

import java.io.Serializable;

public enum ClockType implements Serializable {

	CLOCK_IN("clock-in"), CLOCK_OUT("clock-out");
	
	private String clockType;
	
	private ClockType(String clockType) {
		this.setClockType(clockType);
	}

	public String getClockType() {
		return clockType;
	}

	public void setClockType(String clockType) {
		this.clockType = clockType;
	}
	
}
