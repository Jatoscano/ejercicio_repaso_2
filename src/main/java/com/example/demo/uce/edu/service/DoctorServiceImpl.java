package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.DoctorRepository;
import com.example.demo.uce.edu.repository.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public void registrar(Doctor doctor) {
		
		this.doctorRepository.insertar(doctor);
	}

	@Override
	public void guardar(Doctor doctor) {
		
		this.doctorRepository.actualizar(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		
		return this.doctorRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.doctorRepository.eliminar(id);
	}
}
