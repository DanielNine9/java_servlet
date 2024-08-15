package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bean.User;


public class JpaProgram {
	public static void main(String[] args) {
		findAll();
	}

	private static void create() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin(); 
			
			User entity = new User();
			entity.setId("huydqpc07859");
			entity.setFullname("Dinh Quoc Huy");
			entity.setPassword("12341234s");
			entity.setEmail("huydqpc07869@fpt.edu.vn");

			// Insert vào CSDL
			em.persist(entity);
			
			em.getTransaction().commit();// Chap nhận kết quả thao tác
			System.out.println("Thêm thành công");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

	private static void update() {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			
			// Truy vấn thực thể theo id
			User entity = em.find(User.class, "Quangvd");
			
			// Thay đổi thông tin thực thể
			entity.setPassword("123456");
			
			entity.setAdmin(true);
			
			// Cập nhật thực thể
			em.merge(entity);
			
			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Cập nhật thành công");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

	private static void delete() {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			User entity = em.find(User.class, "Quangvd");
			
			em.remove(entity);
			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Xóa thành công");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

	private static void findAll() {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		
		try {
			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM User o";
			
			// Tạo đối tượng truy vấn
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			
			// Truy vấn
			List<User> list = query.getResultList();
			
			// Hiển thị kết quả truy vấn
			for (User user : list) {
				System.out.println(">>Fullname: " + user.getFullname());
				System.out.println(">>IsAdmin? " + user.getAdmin());
			}
		} catch (Exception e) {
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

	private static void findByRole(boolean role) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		
		try {
			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM User o WHERE o.admin=:role";
			
			// Tạo đối tượng truy vấn
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			
			query.setParameter("role", role);
			
			// Truy vấn
			List<User> list = query.getResultList();
			
			// Hiển thị kết quả truy vấn
			for (User user : list) {
				System.out.println(">>Fullname: " + user.getFullname());
				System.out.println(">>IsAdmin? " + user.getAdmin());
			}
			
		} catch (Exception e) {
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

	private static void findByKeyword(String keyword) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		
		try {
			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM User o WHERE o.fullname LIKE :keyword";
			
			// Tạo đối tượng truy vấn
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			
			query.setParameter("keyword", "%" + keyword + "%");
			
			// Truy vấn
			List<User> list = query.getResultList();
			
			// Hiển thị kết quả truy vấn
			for (User user : list) {
				System.out.println(">>Fullname: " + user.getFullname());
				System.out.println(">>IsAdmin? " + user.getAdmin());
			}
		} catch (Exception e) {
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

	private static void findOne(String username, String password) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		
		try {
			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM User o WHERE o.id=:id AND o.password=:pw";
			
			// Tạo đối tượng truy vấn
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			
			query.setParameter("id", username);
			query.setParameter("pw", password);
			
			// Truy vấn một thực thể
			User user = query.getSingleResult();
			
			// Hiển thị kết quả truy vấn
			System.out.println(">>Fullname: " + user.getFullname());
			System.out.println(">>IsAdmin? " + user.getAdmin());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

	private static void findPage(int page, int size) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		
		try {
			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM User o";
			
			// Tạo đối tượng truy vấn
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			
			query.setFirstResult(page * size);
			query.setMaxResults(size);
			
			// Truy vấn
			List<User> list = query.getResultList();
			
			// Hiển thị kết quả truy vấn
			for (User user : list) {
				System.out.println(">>Fullname: " + user.getFullname());
				System.out.println(">>IsAdmin? " + user.getAdmin());
			}
		} catch (Exception e) {
			System.out.println("Action fail");
		}
		
		em.close();
		emf.close();
	}

}

