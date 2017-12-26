package com.practice.orm.hibernate.simpleprogrammer.listener;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class DefaultIntegrator implements Integrator{

	@Override
	public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {

		EventListenerRegistry r = serviceRegistry.getService(EventListenerRegistry.class);
		r.prependListeners(EventType.LOAD, new LoadEventListener());
		
	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory, 
			SessionFactoryServiceRegistry serviceRegistry) {
		
	}


}
