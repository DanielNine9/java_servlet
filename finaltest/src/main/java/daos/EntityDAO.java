package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import beans.EntityName;
import utils.JpaUtils;

public class EntityDAO {
	private static EntityManager em;

	@Override
	protected void finalize() throws Throwable {
		em.close();
//		super.finalize();
	}

	public List<EntityName> findAll(int page, int pageSize) {
		em = JpaUtils.getEntityManager();
		TypedQuery<EntityName> query = em.createQuery("SELECT u FROM EntityName u", EntityName.class);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public long count() {
		em = JpaUtils.getEntityManager();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM EntityName u", Long.class);
		return query.getSingleResult();
	}

	public static EntityName create(EntityName entity) {
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

	public static EntityName update(EntityName entity) {
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

	public EntityName remove(String id) {
		em = JpaUtils.getEntityManager();
		EntityName entity = this.findById(id);

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

	public List<EntityName> findAll() {
		em = JpaUtils.getEntityManager();
		List<EntityName> list = null;

		try {
			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM EntityName o";

			// Tạo đối tượng truy vấn
			TypedQuery<EntityName> query = em.createQuery(jpql, EntityName.class);

			// Truy vấn
			list = query.getResultList();

			// Hiển thị kết quả truy vấn
			for (EntityName EntityName : list) {
				System.out.println(">>Fullname: " + EntityName.getFullname());
				System.out.println(">>IsAdmin? " + EntityName.getAdmin());
			}

			return list;
		} catch (Exception e) {
			System.out.println("Action fail");

			return null;
		} finally {
			em.close();
		}

	}

	public EntityName findById(String id) {
		em = JpaUtils.getEntityManager();
		EntityName entity = em.find(EntityName.class, id);

		return entity;
	}

}


