package com.practice.orm.hibernate.simpleprogrammer.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.practice.orm.hibernate.simpleprogrammer.interceptor.AuditInerceptor;

public class HibernateUtilities {
	
	//Required for Hibernate 4.x
	/*private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
		try {
			Configuration configuration = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch (HibernateException exe) {
			System.err.println("Problem Creating Session Factory");
		}
	}*/

	//Required for Hibernate 5.x
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;

	static {
		try {
			standardServiceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardServiceRegistry)
					.getMetadataBuilder()
					.build()
					;
			
			sessionFactory = metadata.getSessionFactoryBuilder()
			.applyInterceptor(new AuditInerceptor()) //Apply Interceptor
			.build();

		} catch (HibernateException exe) {
			System.err.println("Problem Creating Session Factory");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
