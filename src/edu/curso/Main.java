package edu.curso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

	public static void createPlanetas(EntityManagerFactory emf) {
		
		Lua l1 = new Lua();
		
		l1.setNome("Titan");
		l1.setId(1);
		
		Lua l2 = new Lua();
		
		l2.setNome("Tutan");
		l2.setId(2);
		
		Lua l3 = new Lua();
		
		l3.setNome("Tetan");
		l3.setId(3);
		
		Lua l4 = new Lua();
		
		l4.setNome("Totan");
		l4.setId(4);
		
		Planeta p1 = new Planeta();

		p1.setId(1);
		p1.setDescoberto(new Date());
		p1.setDistanciaSol(4000000);
		p1.setNome("Kripton");
		p1.setQtdLuas(4);
		p1.setTamanho(67000);

		List<Lua> luas = new ArrayList<>();
		
		luas.add(l1);
		luas.add(l2);
		luas.add(l3);
		luas.add(l4);
		
		p1.setLuas(luas);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(l1);
		em.persist(l2);
		em.persist(l3);
		em.persist(l4);
		em.persist(p1);
		em.getTransaction().commit();

		em.close();
	}
	
	public static void pesquisarTodasLuas(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		TypedQuery<Lua> qry = 
				em.createQuery("select l from Lua l", Lua.class);
		List<Lua> luas = qry.getResultList();

		System.out.println("\n-----INFORMAÇÕES DAS LUAS------\n");
		
		for (Lua l : luas) { 
			System.out.println(l);
		}
		em.close();
	}
	
	public static void pesquisarTodosPlanetas(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		TypedQuery<Planeta> qry = 
				em.createQuery("select p from Planeta p", Planeta.class);
		List<Planeta> planetas = qry.getResultList();
		
		System.out.println("\n-----INFORMAÇÕES DO PLANETA------\n");
		
		for (Planeta p : planetas) { 
			System.out.println(p);
		}
		em.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PLANETAS");

//		createPlanetas(emf);
		pesquisarTodasLuas(emf);
		pesquisarTodosPlanetas(emf);
		emf.close();
	}

}
