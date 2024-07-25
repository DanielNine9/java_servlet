package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import bean.Video;
import utils.JpaUtils;


public class VideoDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	public void insert(Video entity) {
		// TODO Auto-generated method stub

	}

	public void update(Video entity) {
		// TODO Auto-generated method stub

	}

	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Video findByID(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Video> findByTitle(String title) {
		String jpql = "SELECT DISTINCT o.video FROM Favorite o WHERE o.video.title LIKE :keyword";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter("keyword", "%" + title + "%");
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Video> findByTitle2(String title) {
		TypedQuery<Video> query = em.createNamedQuery("Video.findByKeyword", Video.class);
		query.setParameter("keyword", "%" + title + "%");
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Video> findFavorite(boolean check) {
		String jpql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
		if (check) {
			jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
		}
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Video> findByUser(String id) {
		TypedQuery<Video> query = em.createNamedQuery("Video.findByUser", Video.class);
		query.setParameter("id", id);
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Video> findInRange(Date from, Date to) {
		TypedQuery<Video> query = em.createNamedQuery("Video.findInRange", Video.class);
		query.setParameter("min", from);
		query.setParameter("max", to);
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Video> findByMonth(List<Integer> months) {
		TypedQuery<Video> query = em.createNamedQuery("Video.findInMonths", Video.class);
		query.setParameter("months", months);
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Video> random10() {
		Query query = em.createNamedQuery("Report.random10");
		List<Video> list = query.getResultList();
		return list;
	}
}
