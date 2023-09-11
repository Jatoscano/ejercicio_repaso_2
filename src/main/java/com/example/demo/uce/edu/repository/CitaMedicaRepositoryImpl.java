package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CitaMedica citaMedica) {
		
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica seleccionar(Integer id) {
		
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public CitaMedica seleccionarCita(String numeroCita) {
		//SQL
		//SELECT * FROM  citaMedica cm WHERE cm.cime_numero_cita = 
						
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT cm FROM CitaMedica cm WHERE cm.numeroCita = :""
				
		Query query =this.entityManager.createQuery("SELECT cm FROM CitaMedica cm "
												  + "WHERE cm.numeroCita = :datoNumeroCita");
		query.setParameter("datoNumeroCita", numeroCita);
		return (CitaMedica)query.getSingleResult();
	}
	
	
}
