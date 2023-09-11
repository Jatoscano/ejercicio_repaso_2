package com.example.demo.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.uce.edu.repository.model.CitaMedica;

public interface CitaMedicaService {

	public void registrar(CitaMedica citaMedica);
	public void guardar(CitaMedica citaMedica);
	public CitaMedica buscar(Integer id);
	public void borrar(Integer id);
	
	public void agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, 
			  				String lugarCita, String cedulaDoctor, String cedulaPaciente);

	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);
}
