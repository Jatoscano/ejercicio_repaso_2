package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.CitaMedica;

public interface CitaMedicaRepository {

	public void insertar(CitaMedica citaMedica);
	public void actualizar(CitaMedica citaMedica);
	public CitaMedica seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public CitaMedica seleccionarCita(String numeroCita);
}	
