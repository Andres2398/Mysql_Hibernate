package pasarela;
import jakarta.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

import entidades.GenericDao;

public class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {

    protected EntityManager em;
    private Class<T> entityClass;

    
    @SuppressWarnings("unchecked")
	public GenericDaoImpl(EntityManager em) {
        this.em = em;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void crear(T entidad) {
        em.persist(entidad);
    }

    @Override
    public T buscarPorId(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public T actualizar(T entidad) {
        return em.merge(entidad);
    }
    
    
    @Override
    public void eliminar(T entidad) {
       
        em.remove(em.contains(entidad) ? entidad : em.merge(entidad));
    }
}