package training.dao;

import training.entity.Type;

import java.util.List;
import java.util.Optional;

public interface TypeDao {

    void createType(Type type);

    Optional<Type> getTypeById(Integer typeId);

    List<Type> getAllType();

    Optional<Type> updateTypeById(Type type);

    Optional<Type> deleteTypeById(Integer typeId);
}
