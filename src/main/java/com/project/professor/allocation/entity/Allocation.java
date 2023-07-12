package com.project.professor.allocation.entity;

import java.sql.Time;
import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLong;

	@Column(name = "DayOfWeek", nullable = false)
	private DayOfWeek dayOfWeek;

	@Column(name = "hourStart", nullable = false)
	private Time hourStart;

	@Column(name = "hourEndTime", nullable = false)
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
