package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImp  implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        Query query = entityManager.createQuery("from roles");
        List<Role> result = query.getResultList();
        return result;
    }

    @Override
    public Role findByUserName(String name) {
        Query query = entityManager.createQuery("from Role where name = :name", Role.class);
        query.setParameter("name", name);
        return (Role) query.getSingleResult();
    }
}
