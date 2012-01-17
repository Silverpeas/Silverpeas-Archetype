package ${package}.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ${package}.model.Sample;

/* 
 * DAO sample using Spring JPA 
 * Must extend JpaRepository
 * */
public interface SampleDAO /*extends JpaRepository<Sample, Integer>*/ {

	@Query("from Sample s WHERE s.componentId = :myId")
	public List<Sample> getAll(@Param("myId") String componentId);

}
