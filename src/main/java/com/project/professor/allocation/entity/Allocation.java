package com.project.professor.allocation.entity;

import java.sql.Time;
import java.time.DayOfWeek;

import javax.persistence.*;

@Entity
@Table(name="allocation")
public class Allocation {
	
	@Id
	@Column(name = "idLong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLong;

	@Enumerated(EnumType.STRING)
    @Column(name = "dayOfWeek", nullable = false)
	private DayOfWeek dayOfWeek;

	
	@Temporal(TemporalType.TIME)
    @Column(name = "hourStart", nullable = false)
	private Time hourStart;

	@Temporal(TemporalType.TIME)
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
