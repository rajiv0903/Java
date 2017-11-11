package com.practice.orm.hibernate.simpleprogrammer;

import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import com.practice.orm.hibernate.simpleprogrammer.model.GoalAlert;
import com.practice.orm.hibernate.simpleprogrammer.model.ProteinData;
import com.practice.orm.hibernate.simpleprogrammer.model.User;
import com.practice.orm.hibernate.simpleprogrammer.model.UserHistory;
import com.practice.orm.hibernate.simpleprogrammer.utils.HibernateUtilities;

public class Program {

	public static void main(String args[]) {

		System.out.println("Hello World!");

		populateSampleData();
		
		//Querying
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		/*Query query = session.createQuery("from User");
		List<User> users = query.list();
		for(User user: users) {
			System.out.println(user.getName());
		}*/
		
		/**Create Query **/
		/*Query query = session.createQuery("select user from User user where user.name =:name");
		query.setString("name", "Rajiv");
		List<User> users = query.list();
		for (User user : users) {
			System.out.println(user.getName());
		}*/
		
		/**Create Query **/
		/*Query query = session.createQuery("from GoalAlert")
				.setFirstResult(2)
				.setMaxResults(1);
		
		List<GoalAlert> alerts = query.list();
		for (GoalAlert alert : alerts) {
			System.out.println(alert.getMessage());
		}*/
		
		/**Named Query **/
		/*Query query = session.getNamedQuery("AllGoalAlerts");
		
		List<GoalAlert> alerts = query.list();
		for (GoalAlert alert : alerts) {
			System.out.println(alert.getMessage());
		}*/
		
		/**Implicit Join **/
	/*	Query query = session.createQuery("select user from User user where user.proteinData.total > 0");
		List<User> users = query.list();
		for (User user : users) {
			System.out.println(user.getName());
		}*/
		
		/**Explicit Join **/
		/*Query query = session.createQuery("select user from User user, GoalAlert ga "
				+ " where user.id = ga.id");
		List<User> users = query.list();
		for (User user : users) {
			System.out.println(user.getName());
		}*/
		
		/** Dynamic Instantiation**/
		/*Query query = session.createQuery("select new com.practice.orm.hibernate.simpleprogrammer."
				+ "model.UserTotal(user.name, user.proteinData.total) "
				+ " from User user");
		List<UserTotal> userTotals = query.list();
		for (UserTotal ut : userTotals) {
			System.out.println(ut.getName()+ " "+ ut.getTotal());
		}*/

		/**Criteria Query : With Restriction and Projections**/
	/*	Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.or(Restrictions.eq("name", "Rajiv"), Restrictions.eq("name", "Tithi")
				)).setProjection(
						Projections.projectionList()
						.add(Projections.property("name"))
						.add(Projections.property("id"))
				);

		List<Object[]> results = criteria.list();
		for (Object[] result : results) {
			for( Object o: result) {
				System.out.println(o.toString());
			}
		}*/
		
		/**Criteria Query Alias : With Restriction and Projections**/
	/*	Criteria criteria = session.createCriteria(User.class)
				.createAlias("proteinData", "pd")
				.add(Restrictions.or(Restrictions.eq("name", "Rajiv"), Restrictions.eq("name", "Tithi")
				)).setProjection(
						Projections.projectionList()
						.add(Projections.property("pd.total"))
				);

		List<Object> results = criteria.list();
		for (Object result : results) {
			System.out.println(result.toString());
		}*/
		
		/**Ecample Criteria Query**/
		/*User u = new User();
		u.setName("rajiv");
		Example e =  Example.create(u).ignoreCase();
		
		Criteria criteria = session.createCriteria(User.class)
				.add(e);
		List<User> users = criteria.list();
		for (User user : users) {
			System.out.println(user.getName());
		}*/
		
		
		/*Criteria criteria = session.createCriteria(User.class);
		List<User> users = criteria.list();
		for(User user: users) {
			System.out.println(user.getName());
		}*/
		/**Batch Processing**/
		/*Query query = session.createQuery("update ProteinData pd set pd.total = 0");
		query.executeUpdate();*/
		
		/**Batch Processing: Manual - Create a cursor**/
		/*Criteria criteria = session.createCriteria(User.class);
		ScrollableResults users = criteria.setCacheMode(CacheMode.IGNORE).scroll();
		int count = 0;
		while(users.next()) {
			User user = (User) users.get(0);
			user.setProteinData(new ProteinData());
			session.save(user);
			if(++ count %2 ==0) {
				session.flush();
				session.clear();
			}
			System.out.println(user.getName());
		}
		*/
		
		/**Native SQL**/
		/*Query query = session.createSQLQuery("select * from users").addEntity(User.class);
		List<User> users = query.list();
		for (User user : users) {
			System.out.println(user.getName());
		}*/
		
		/**Filter Query**/
		
		session.enableFilter("nameFilter").setParameter("name", "R%");
		
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		for(User user: users) {
			System.out.println(user.getName());
		}
		
		session.getTransaction().commit();
		session.close();
		//End

		HibernateUtilities.getSessionFactory().close();
	}

	private static void populateSampleData() {

		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User rajiv = createUser("Rajiv", 11L, (short) 12, 100.00f, 80.00, 'Y', true, 1000, 500, "Good job!",
				"Yo made it!");
		session.save(rajiv);

		User tithi = createUser("Tithi", 21L, (short) 22, 100.00f, 80.00, 'Y', true, 500, 250, "Taco time!");
		session.save(tithi);

		User mahika = createUser("Mahika", 31L, (short) 32, 100.00f, 80.00, 'Y', true, 700, 300, "Yes!");
		session.save(mahika);

		session.getTransaction().commit();
		session.close();
	}

	private static User createUser(String name, long primaryId, short surogateId, float amount, double paid,
			char active, boolean proteinTaker, int goal, int total, String... alerts) {

		User user = new User(); // Create User
		user.setName(name);

		user.setPrimaryId(primaryId);
		user.setSurogateId(surogateId);
		user.setAmount(amount);
		user.setPaid(paid);
		user.setActive(active);
		user.setProteinTaker(proteinTaker);

		user.getProteinData().setGoal(goal);
		user.addHistory(new UserHistory(new Date(), "Set goal for " + name + " to " + goal));
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(), "Set goal for " + name + " to " + total));

		for (String alert : alerts) {
			user.getGoalAlerts().add(new GoalAlert(alert)); // Join table
		}

		return user;
	}
}
