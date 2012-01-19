package ${package}.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ${package}.model.MyEntity;

/* 
 * Repository sample using Spring JPA 
 * Must extend JpaRepository
 * */
public interface MyEntityRepository /*extends JpaRepository<MyEntity, Integer>*/ {

	@Query("from MyEntity s WHERE s.componentId = :myId")
	public List<MyEntity> getAll(@Param("myId") String componentId);

}
