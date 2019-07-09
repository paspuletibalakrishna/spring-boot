package com.bala.models;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class DateContainer {
	
	@NotNull(message = "Please enter Start Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
	
	@NotNull(message = "Please enter End Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
	
	
	
    

}
