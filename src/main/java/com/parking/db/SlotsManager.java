package com.parking.db;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
public class SlotsManager {
	static EntityManagerFactory factory;
	static EntityManager entiryManager;
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory("SlotUnit");
		entiryManager = factory.createEntityManager();
		entiryManager.getTransaction().begin();
		
		
		Slots slot = new Slots();
		slot.setCarnumber("sd78fd5900");
		slot.setSlotnumber(1);
		slot.setIntime((long) 1534351135);
		
		entiryManager.persist(slot);
		
		entiryManager.getTransaction().commit();
		entiryManager.close();
		factory.close();
	}

}
