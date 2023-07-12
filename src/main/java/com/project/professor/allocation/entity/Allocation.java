package com.project.professor.allocation.entity;

import java.sql.Time;
import java.time.DayOfWeek;

public class Allocation {
	
	private Long idLong;
	private DayOfWeek dayOfWeek;
	private Time hourStart;
	private Time hourEndTime;

	public Long getIdLong() {
		return idLong;
	}

	public void setIdLong(Long idLong) {
		this.idLong = idLong;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Time getHourStart() {
		return hourStart;
	}

	public void setHourStart(Time hourStart) {
		this.hourStart = hourStart;
	}

	public Time getHourEndTime() {
		return hourEndTime;
	}

	public void setHourEndTime(Time hourEndTime) {
		this.hourEndTime = hourEndTime;
	}

}
