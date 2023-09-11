package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements PacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente seleccionar(Integer id) {
		
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public Paciente seleccionarCedula(String cedula) {
		
		//SQL
		//SELECT * FROM  paciente pc WHERE pc.paci_cedula = 
										
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT pc FROM Paciente pc WHERE pc.cedula = :""
								
		Query query =this.entityManager.createQuery("SELECT pc FROM Paciente pc WHERE pc.cedula = :datoCedula");
		query.setParameter("datoCedula", cedula);
		return (Paciente)query.getSingleResult();
	}
	
	
}
