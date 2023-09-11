package com.example.demo.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.CitaMedicaRepository;
import com.example.demo.uce.edu.repository.DoctorRepository;
import com.example.demo.uce.edu.repository.PacienteRepository;
import com.example.demo.uce.edu.repository.model.CitaMedica;
import com.example.demo.uce.edu.repository.model.Doctor;
import com.example.demo.uce.edu.repository.model.Paciente;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{

	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Override
	public void registrar(CitaMedica citaMedica) {
		
		this.citaMedicaRepository.insertar(citaMedica);
	}

	@Override
	public void guardar(CitaMedica citaMedica) {
		
		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public CitaMedica buscar(Integer id) {
		
		return this.citaMedicaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.citaMedicaRepository.eliminar(id);
	}

	@Override
	public void agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, 
							String lugarCita, String cedulaDoctor, String cedulaPaciente) {
		//1. Escogemos a nuestro paciente
		System.out.println("Estamos buscando el paciente al ser atendido...");
		Paciente paciente = this.pacienteRepository.seleccionarCedula(cedulaPaciente);
		System.out.println("Paciente Encontrado: ");
		System.out.println(paciente);
		
		//2. Escogemos a nuestro doctor
		System.out.println("Estamos buscando el doctor para la atencion...");
		Doctor doctor = this.doctorRepository.seleccionarCedula(cedulaDoctor);
		System.out.println("Doctor Encontrado: ");
		System.out.println(doctor);
		
		//3. Agendamos la cita
		System.out.println("La cita agendada es la siguiente: ");
		CitaMedica citaMedica = new CitaMedica();
		List<CitaMedica> registro = new ArrayList<>();
		citaMedica.setNumeroCita(numeroCita);
		citaMedica.setValorCita(valorCita);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setLugarCita(lugarCita);
		
		citaMedica.setDoctor(doctor);
		citaMedica.setPaciente(paciente);
		
		registro.add(citaMedica);
		
		doctor.setCitasMedicas(registro);
		paciente.setCitasMedicas(registro);
		System.out.println("Estamos realizando la cita correspondiente...");
		this.registrar(citaMedica);
		System.out.println("Cita Medica realizada con exito...");
		System.out.println(citaMedica);
	}

	@Override
	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		
		//1. Seleccionamos la cita por su numero
		CitaMedica citaMedica = this.citaMedicaRepository.seleccionarCita(numeroCita);
		
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setFechaProximaCita(fechaProximaCita);
		
		System.out.println("Estamos realizando la actualizacion de la cita correspondiente...");
		this.guardar(citaMedica);
		System.out.println("Actualizacion de Cita Completado...");
		System.out.println(citaMedica);
	}
	
	
}
