package com.app.softtek.dto;

public class EmployeDto {

	private String id;
	private String name;
	private String lastName;
	private String dni;
	private boolean active;
	
	public EmployeDto() {}
	
	public EmployeDto(String id, String name, String lastName, String dni, boolean active) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.active = active;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "EmployeDto [id=" + id + ", name=" + name + ", lastName=" + lastName + ", dni=" + dni + ", active="
				+ active + "]";
	}
}
