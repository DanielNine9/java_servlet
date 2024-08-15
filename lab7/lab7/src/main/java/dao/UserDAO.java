package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bean.User;
import utils.JpaUtils;

public class UserDAO {
	private static EntityManager em;

	@Override
	protected void finalize() throws Throwable {
		em.close();
//		super.finalize();
	}

	public List<User> findAll(int page, int pageSize) {
		em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public long count() {
		em = JpaUtils.getEntityManager();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM User u", Long.class);
		return query.getSingleResult();
	}

	public static User create(User entity) {
		em = JpaUtils.getEntityManager();
		System.out.println("entity" + entity.getFullname());
		try {
			em.getTransaction().begin();

			em.persist(entity);

			em.getTransaction().commit();
			System.out.println("Thêm thành công");
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Action fail");
			return null;
		} finally {
			em.close();
		}

	}

	public static User update(User entity) {
		em = JpaUtils.getEntityManager();

		try {
			em.getTransaction().begin(); // Bắt đầu Transaction

			// Cập nhật thực thể
			em.merge(entity);

			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Cập nhật thành công");

			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Action fail");

			return null;
		} finally {
			em.close();
		}

	}

	public User remove(String id) {
		em = JpaUtils.getEntityManager();
		User entity = this.findById(id);

		try {
			em.getTransaction().begin(); // Bắt đầu Transaction

			em.remove(entity);
			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Xóa thành công");

			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Action fail");

			return null;
		} finally {
			em.close();
		}

	}

	public List<User> findAll() {
		em = JpaUtils.getEntityManager();
		List<User> list = null;

		try {
			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM User o";

			// Tạo đối tượng truy vấn
			TypedQuery<User> query = em.createQuery(jpql, User.class);

			// Truy vấn
			list = query.getResultList();

			// Hiển thị kết quả truy vấn
			for (User user : list) {
				System.out.println(">>Fullname: " + user.getFullname());
				System.out.println(">>IsAdmin? " + user.getAdmin());
			}

			return list;
		} catch (Exception e) {
			System.out.println("Action fail");

			return null;
		} finally {
			em.close();
		}

	}
	public List<User> find(String find) {
	    List<User> list = new ArrayList<>();
	    em = JpaUtils.getEntityManager();
	    try {
	        // Building the query based on input parameters
	        String queryStr = "SELECT u FROM User u WHERE u.id LIKE :id OR u.fullname LIKE :fullname";
	        TypedQuery<User> query = em.createQuery(queryStr, User.class);
	        query.setParameter("id", "%" + find + "%");
	        query.setParameter("fullname", "%" + find + "%");
	        
	        // Executing the query and getting the result list
	        list = query.getResultList();
	    } finally {
	        em.close();
	    }
	    return list;
	}


	public User findById(String id) {
		em = JpaUtils.getEntityManager();
		User entity = em.find(User.class, id);

		return entity;
	}

}
