import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import training.dao.TypeDao;
import training.dao.impl.TypeDaoImpl;
import training.entity.Type;

import static org.junit.jupiter.api.Assertions.*;

public class TypeDaoImplTest {
    static TypeDao typeDao;

    @BeforeAll
    static void beforeAll(){
        typeDao = new TypeDaoImpl();
    }

    @Test
    void get_Type_By_Id_Success_Test(){
        assertNotNull(typeDao.getTypeById(1));
    }

    @Test
    void get_Type_By_Id_Fail_Test(){
        assertNull(typeDao.getTypeById(100));
    }

    @Test
    void get_All_Type_Success_Test(){
        assertTrue(typeDao.getAllType().size() > 0);
    }

    @Test
    void get_All_Type_Fail_Test(){
        assertTrue(typeDao.getAllType().size() == 0);
    }

    @Test
    void update_Type_By_Id_Success_Test(){
        Type type = new Type();
        type.setTypeId(1);
        type.setTypeName("Type 01");
        type.setTypeDescription("Type description 01");
        typeDao.updateTypeById(type);
        assertNotNull(typeDao.updateTypeById(type));
    }

    @Test
    void update_Type_By_Id_Fail_Test(){
        Type type = new Type();
        type.setTypeId(100);
        type.setTypeName("Type 100");
        type.setTypeDescription("Type description 01");
        typeDao.updateTypeById(type);
        assertNull(typeDao.updateTypeById(type));
    }

    @Test
    void delete_Type_By_Id_Success_Test(){
        assertNotNull(typeDao.deleteTypeById(1));
    }

    @Test
    void delete_Type_By_Id_Fail_Test(){
        assertNull(typeDao.deleteTypeById(100));
    }
}
