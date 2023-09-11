package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		
		this.entityManager.persist(doctor);
	}

	@Override
	public void actualizar(Doctor doctor) {
		
		this.entityManager.merge(doctor);
	}

	@Override
	public Doctor seleccionar(Integer id) {
		
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public Doctor seleccionarCedula(String cedula) {
		
		//SQL
		//SELECT * FROM  doctor dc WHERE dc.doct_cedula = 
								
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT dc FROM Doctor dc WHERE dc.cedula = :""
						
		Query query =this.entityManager.createQuery("SELECT dc FROM Doctor dc WHERE dc.cedula = :datoCedula");
		query.setParameter("datoCedula", cedula);
		return (Doctor)query.getSingleResult();
	}
	
	
}
