package org.jboss.test.drools.cep.demo.model;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TimeRecordEvent implements Fact {

	private static final long serialVersionUID = 6681202230060207052L;

	private String id;
	private  Staff staff;
	private  ClockType clockType;
	private Date timestamp;
	private boolean issue;
	private String reason;
	private Integer otBeforeShift;
	private Integer otAfterShift;
	private Integer totalDuringShift;
	
	public Integer getTotalDuringShift() {
		return totalDuringShift;
	}

	public void setTotalDuringShift(Integer totalDuringShift) {
		this.totalDuringShift = totalDuringShift;
	}

	public boolean isIssue() {
		return issue;
	}

	public void setIssue(boolean issue) {
		this.issue = issue;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getOtBeforeShift() {
		return otBeforeShift;
	}

	public void setOtBeforeShift(Integer otBeforeShift) {
		this.otBeforeShift = otBeforeShift;
	}

	public Integer getOtAfterShift() {
		return otAfterShift;
	}

	public void setOtAfterShift(Integer otAfterShift) {
		this.otAfterShift = otAfterShift;
	}

	public TimeRecordEvent(Staff staff, ClockType clockType) {
		this(staff, clockType, new Date());
	}
	
	public TimeRecordEvent(Staff staff, ClockType clockType, Date eventTimestamp) {
		this(UUID.randomUUID().toString(), staff,clockType, eventTimestamp);
	}
	
	public TimeRecordEvent(String id, Staff staff, ClockType clockType, Date eventTimestamp) {
		this.setId(id);
		this.staff = staff;
		this.clockType = clockType;
		this.timestamp = eventTimestamp;
	}

	public ClockType getClockType() {
		return clockType;
	}

	public Staff getStaff() {
		return staff;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date eventTimestamp) {
		this.timestamp = eventTimestamp;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("staff", staff).append("clockType", clockType).append("timestamp", timestamp).toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
