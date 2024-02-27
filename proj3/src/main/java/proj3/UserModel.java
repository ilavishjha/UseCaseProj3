package proj3;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;



public class UserModel {
public void add(UserDTO dto) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
	session.save(dto);
	tx.commit();
	session.close();
	
	
	
}
public void update(UserDTO dto) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
	session.update(dto);
	tx.commit();
	session.close();
}
public void delete(UserDTO dto) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
	session.delete(dto);
	tx.commit();
	session.close();
}
public List search(UserDTO dto) {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	Criteria c = session.createCriteria(UserDTO.class);
	if (dto != null) {
		if (dto.getName() != null && dto.getName().length() > 0) {
			c.add(Restrictions.like("name", dto.getName() + "%"));
		}
	}
	List list = c.list();
	tx.commit();
	session.close();
	return list;

}

public UserDTO findByPk(int id) {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	Query q = session.createQuery("from UserDTO where Id=?");
	q.setInteger(0, id);

	List list = q.list();
	UserDTO dto = null;
	if (list.size() > 0) {
		dto = (UserDTO) list.get(0);
	}
	tx.commit();
	session.close();
	return dto;
	
	
}
}

