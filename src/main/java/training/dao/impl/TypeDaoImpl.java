package training.dao.impl;

import org.hibernate.Session;
import training.dao.TypeDao;
import training.entity.Type;
import training.utils.XmlConnectionConfig;

import java.util.List;
import java.util.Optional;

public class TypeDaoImpl implements TypeDao {
    @Override
    public void createType(Type type) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            session.persist(type);
            session.getTransaction().commit();
        }
    }

    @Override
    public Optional<Type> getTypeById(Integer typeId) {
        try(Session session = XmlConnectionConfig.getSession()) {
            Type type = session.get(Type.class, typeId);
            return Optional.ofNullable(type);
        }
    }

    @Override
    public List<Type> getAllType() {
        try(Session session = XmlConnectionConfig.getSession()) {
            return session.createQuery("SELECT t FROM Type t", Type.class).getResultList();
        }
    }

    @Override
    public Optional<Type> updateTypeById(Type type) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            Type type2 = session.find(Type.class, type.getTypeId());
            if (type2 == null) {
                return null;
            }
            session.merge(type2);
            session.getTransaction().commit();
            return Optional.of(type);
        }
    }

    @Override
    public Optional<Type> deleteTypeById(Integer typeId) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            Type type = session.find(Type.class, typeId);
            if (type == null) {
                return null;
            }else{
                session.remove(type);
                session.getTransaction().commit();
                return Optional.of(type);
            }
        }
    }
}
