package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Doctor;
import com.example.demo.uce.edu.repository.model.Paciente;
import com.example.demo.uce.edu.service.CitaMedicaService;
import com.example.demo.uce.edu.service.DoctorService;
import com.example.demo.uce.edu.service.PacienteService;

@SpringBootApplication
public class EjercicioRepaso2Application implements CommandLineRunner{

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private CitaMedicaService citaMedicaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepaso2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		//Ingresamos el Doctor
		Doctor doctor = new Doctor();
		doctor.setCedula("1738747421");
		doctor.setNombre("Daniela");
		doctor.setApellido("Figueroa");
		doctor.setFechaNacimiento(LocalDateTime.of(1996, 07, 23, 14, 30));
		doctor.setNumeroConsultorio("OF-110");
		doctor.setCodigoSenescyt("SE-1103");
		doctor.setGenero("Femenino");
		
		this.doctorService.registrar(doctor);
		
		//Ingresamos el Paciente
		Paciente paciente = new Paciente();
		paciente.setCedula("1934646786");
		paciente.setNombre("Gerardo");
		paciente.setApellido("Avila");
		paciente.setFechaNacimiento(LocalDateTime.of(1981, 06, 22, 13, 14));
		paciente.setCodigoSeguro("A-1324");
		paciente.setEstatura("1.80");
		paciente.setPeso("69.90");
		paciente.setGenero("Masculino");
		
		this.pacienteService.registrar(paciente);
		
		paciente.setPeso("68.00");
		this.pacienteService.guardar(paciente);
		
		//Ingresamos la Cita Medica
		
		this.citaMedicaService.agendarCita("C-004", LocalDateTime.now(), new BigDecimal(40), "Hospital Pablo Arturo Suarez", "1738747421", "1934646786");
	    this.citaMedicaService.actualizarCita("C-004", "COVID", "Paracetamol", LocalDateTime.of(2023, 9, 14, 12, 00));
	    
	}
}
