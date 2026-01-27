package entidades;

public interface GenericDao<T, ID> {

	void crear(T entidad);

	T buscarPorId(ID id);

	T actualizar(T entidad);

	void eliminar(T entidad);

}
