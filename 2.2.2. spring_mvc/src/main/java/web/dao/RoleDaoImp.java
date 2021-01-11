package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        Query query = entityManager.createQuery("from Role");
        List<Role> result = query.getResultList();
        return result;
    }

    @Override
    public Role getRoleByName(String roleName) {
        Query query = entityManager.createQuery("from Role where name = :name", Role.class);
        query.setParameter("name", roleName);
        return (Role) query.getSingleResult();
    }


}
