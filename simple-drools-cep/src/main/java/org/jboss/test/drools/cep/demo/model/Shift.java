package org.jboss.test.drools.cep.demo.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shift implements Fact{

	private static final long serialVersionUID = -2485304547757244174L;

	private static final Integer bufferInMinute = 30;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd:HHmmssSSS");
	private static final Logger LOGGER = LoggerFactory.getLogger(Shift.class);
	
	private String id;
	
	private Staff staff;
	
	private Date shiftStart;
	private Date shiftEnd;
	private Date minClockIn;
	private Date lateClockOut;
	
	
	
	public Shift(String staffId, String startDate, String endDate, String bufferInMinute) {

		try {
			this.staff = new Staff(staffId);

			Date startD = DATE_FORMAT.parse(startDate);
			Date endD = DATE_FORMAT.parse(endDate);

			Integer buffer = Integer.parseInt(bufferInMinute);

			Calendar calStartD = Calendar.getInstance();
			calStartD.setTime(startD);
			calStartD.add(Calendar.MINUTE, -buffer);

			Calendar calEndD = Calendar.getInstance();
			calEndD.setTime(endD);
			calEndD.add(Calendar.MINUTE, buffer);

			this.minClockIn =calStartD.getTime();
			this.lateClockOut = calEndD.getTime();
			this.shiftStart = startD;
			this.shiftEnd = endD;
			
		} catch (ParseException e) {
			LOGGER.error("Error parsing ", e);
		}
	}
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getShiftStart() {
		return shiftStart;
	}
	
	public Date getShiftStart(String startTime, String endTime ) {
		
		return shiftStart;
	}
	
	public void setShiftStart(Date shiftStart) {
		this.shiftStart = shiftStart;
	}
	public Date getShiftEnd() {
		return shiftEnd;
	}
	public void setShiftEnd(Date shiftEnd) {
		this.shiftEnd = shiftEnd;
	}
	public Date getMinClockIn() {
		return minClockIn;
	}
	public void setMinClockIn(Date minClockIn) {
		this.minClockIn = minClockIn;
	}
	public Date getLateClockOut() {
		return lateClockOut;
	}
	public void setLateClockOut(Date lateClockOut) {
		this.lateClockOut = lateClockOut;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
