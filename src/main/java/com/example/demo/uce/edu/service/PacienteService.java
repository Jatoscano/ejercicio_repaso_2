package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Paciente;

public interface PacienteService {

	public void registrar(Paciente paciente);
	public void guardar(Paciente paciente);
	public Paciente buscar(Integer id);
	public void borrar(Integer id);
}
