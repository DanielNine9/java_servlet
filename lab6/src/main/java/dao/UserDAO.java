package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import bean.User2;
import utils.JpaUtils;


public class UserDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	public void insert(User2 entity) {
		// TODO Auto-generated method stub
	}

	public void update(User2 entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String key) {
		// TODO Auto-generated method stub
		
	}

	public List<User2> findAll() {
		String jpql = "SELECT o FROM User o";
		TypedQuery<User2> query = em.createQuery(jpql, User2.class);
		List<User2> list = query.getResultList();
		return list;
	}

	public User2 findByID(String key) {
		// TODO Auto-generated method stub
		User2 entity = em.find(User2.class, key);
		return entity;
	}
	
	public List<User2> findUserLikeVideo(String id) {
		String jpql = "SELECT o.user FROM Favorite o WHERE o.video.id=:vid";
		TypedQuery<User2> query = em.createQuery(jpql, User2.class);
		query.setParameter("vid", id);
		List<User2> list = query.getResultList();
		return list;
	}
}
