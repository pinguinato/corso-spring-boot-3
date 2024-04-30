package repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.entity.CountryEntity;
import jakarta.transaction.Transactional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
	
	
	/* esempio di query in dialetto JPA */
	
	List<CountryEntity> findByCountryName(String countryName);
	
	/* esempio di query nativa */
	
	@Query(value = "select * from `esempio-jpa`.country c where c.country_name like :cn", nativeQuery = true)
	List<CountryEntity> selByDescrizioneLike(@Param("cn") String cn);
	
	/* esempio di query JPQL */
	
	@Query(value = "from CountryEntity where countryName like :cn")
	List<CountryEntity> selByDescrizioneLikeJPQL(@Param("cn") String cn);
	
	/* esempio di query di eliminazione */
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM `esempio-jpa`.country c WHERE c.country_name like :cn", nativeQuery = true)
	void delRowCountryName(@Param("cn") String cn);
}
