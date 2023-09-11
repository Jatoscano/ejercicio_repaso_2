package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Paciente;

public interface PacienteRepository {

	public void insertar(Paciente paciente);
	public void actualizar(Paciente paciente);
	public Paciente seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public Paciente seleccionarCedula(String cedula);
}
