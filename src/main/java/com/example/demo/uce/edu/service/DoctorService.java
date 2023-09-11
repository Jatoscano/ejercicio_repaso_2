package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Doctor;

public interface DoctorService {

	public void registrar(Doctor doctor);
	public void guardar(Doctor doctor);
	public Doctor buscar(Integer id);
	public void borrar(Integer id);
}
