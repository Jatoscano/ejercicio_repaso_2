package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Doctor;

public interface DoctorRepository {

	public void insertar(Doctor doctor);
	public void actualizar(Doctor doctor);
	public Doctor seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public Doctor seleccionarCedula(String cedula);
}
