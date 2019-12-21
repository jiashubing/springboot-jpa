package com.space.jpa.dao;

import com.space.jpa.bean.Configuration;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConfigurationDao extends CrudRepository<Configuration, Long>,
        JpaSpecificationExecutor<Configuration> {

	Configuration findById(Long id);
	
	Configuration findByKey(String key);
	
	@Query("select u from Configuration u where u.type =?1 and u.key =?2")
	Configuration findByTypeAndKey(String type, String key);
	
	@Query("select u from Configuration u where u.type =?1 and u.key in (?2)")
	List<Configuration> findByTypeAndKeys(String type, String[] keys);
	
	@Query("select u from Configuration u where u.key in (?1)")
	List<Configuration> findByKeys(String[] keys);
	
	@Query("select u from Configuration u where u.type =?1")
	List<Configuration> listByType(String type);

	@Modifying
    @Transactional
    @Query("update Configuration u set u.value = ?2 where u.key =?1")
    void updateValueByKey(String key, String value);

	@Modifying
	@Transactional
	@Query("update Configuration u set u.value = ?3 where u.key = ?1 and u.type = ?2")
	void updateValueByKeyAndType(String key, String type, String value);

    @Query("select u from Configuration u where u.key like ?1")
    List<Configuration> listAuthTime(String key);
    
    
    @Query("select u from Configuration u where u.key =  ?1")
    Configuration getConfigOnlyByKey(String key);
    
    @Modifying
	@Transactional
	@Query("update Configuration u set u.type = ?1 where u.id =?2")
	int modifyType(String type, long id);

	@Modifying
	@Transactional
	@Query("update Configuration u set u.key = ?1 where u.id =?2")
	int modifyKey(String key, long id);

	@Modifying
	@Transactional
	@Query("update Configuration u set u.dataType = ?1 where u.id =?2")
	int modifyDataType(String dataType, long id);

	@Modifying
	@Transactional
	@Query("update Configuration u set u.typeName = ?1 where u.id =?2")
	int modifyTypeName(String typeName, long id);
	
	@Modifying
	@Transactional
	@Query("update Configuration u set u.description = ?1 where u.id = ?2")
	int modifyDescription(String description, Long id);
}
