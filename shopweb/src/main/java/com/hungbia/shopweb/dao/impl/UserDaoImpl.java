package com.hungbia.shopweb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hungbia.shopweb.dao.UserDao;
import com.hungbia.shopweb.entity.User;

@Transactional // tinh bao toan du lieu
//goi nhiều hàm 1 lúc nếu 1 hàm xảy ra lỗi thì n sẽ rollback lại
@Repository // lop dao
public class UserDaoImpl implements UserDao {
	@PersistenceContext // tuong tu auu wire
	EntityManager entityManager;
//	@Autowired
//	SessionFactory sessionFatory;
	// @Autowired
	// DataSource dataSource;data.connectin...sql

	@Override
	public void add(User user) {
		// sessionFatory.getCurrentSession().save(user);
		entityManager.persist(user);

	}

	@Override
	public void update(User user) {
		entityManager.merge(user);

	}

	@Override
	public void delete(User user) {
		entityManager.remove(user);

	}

	@Override
	public User getUserByID(int id) {
		// return (User) sessionFatory.getCurrentSession().get(User.class, id);
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getAllUser() {// sd cau lenh JQL lam viec voi class entity
		String jql = "SELECT u FROM User u";
		return entityManager.createQuery(jql, User.class).getResultList();
		// tra ve 1 danh sach user
//		String hql = "SELECT p FROM USER u WHERE p.name = :param";
//		Query query = entityManager.createNamedQuery(hql);
//		query.setParameter
	}

	@Override
	public User searchUsername(String username) {
		// String hql = "SELECT u FROM User u where u.username = :param";
		// return entityManager.createQuery(hql, User.class).setParameter("param",
		// username).getSingleResult();
		// trả về 1 đối tượng

		String hql = "SELECT e FROM User e where e.username = :param";
		Query query = entityManager.createQuery(hql);
		query.setParameter("param", username);
		return (User) query.getSingleResult();

	}

	@Override
	public List<User> searchRole(String role) {
		String jql = "SELECT u FROM User u where e.role like :param";
		return entityManager.createQuery(jql, User.class).setParameter("param", role).getResultList();
		// trả về 1 list đối tượng
//		String hql = "SELECT u FROM User u  where u.role like :param";
//		javax.persistence.Query query = entityManager.createQuery(hql);
//		query.setParameter("param", role);
//		return query.getResultList();
	}

	@Override
	public List<User> searchName(String keyword) {
		String hql = "SELECT u FROM User u where u.name like :param";
		return entityManager.createQuery(hql, User.class).setParameter("param", "%" + keyword + "%").getResultList();
	}
}
