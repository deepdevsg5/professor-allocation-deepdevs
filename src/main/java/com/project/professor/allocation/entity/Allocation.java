package com.project.professor.allocation.entity;

import java.sql.Time;
import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

@Entity
public class Allocation {
	
	@JsonProperty(access = Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DayOfWeek", nullable = false)
	private DayOfWeek dayOfWeek;
	
	@Schema(example = "19:00:00", type = "string")
	@Column(name = "hourStart", nullable = false)
	private Time hourStart;
	
	@Schema(example = "20:00:00",type = "string")
	@Column(name = "hourEndTime", nullable = false)
	private Time hourEndTime;
	
	@Schema(allOf = Professor.class, accessMode = AccessMode.READ_ONLY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Professor professor;
	
	@Schema(allOf = Course.class, accessMode = AccessMode.READ_ONLY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Course course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
		
	@Override
    public String toString() {
        return "Allocation { " +
                "	 Id : " + id +
                "\n Day Of Week :" + dayOfWeek +
                "\n Start Hour :" + hourStart +
                "\n  End Hour:" + hourEndTime +
                "\n  Professor: " + professor +
                "\n  Course: " + course +
                '}';
    }
	
	public void setIdProfessor(Long professorId) {
		Professor professor = new Professor();
		professor.setId(professorId);
		this.setProfessor(professor);		
	}
	
	public void setIdCourse(Long courseId) {
		Course course = new Course();
		course.setId(courseId);
		this.setCourse(course);
	}
	
	

}
