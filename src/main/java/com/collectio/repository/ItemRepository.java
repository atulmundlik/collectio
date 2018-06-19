package com.collectio.repository;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.collectio.model.Item;

public interface ItemRepository extends Neo4jRepository<Item, Long> {

	Item findByItemName(@Param("itemName") String itemName);

	Collection<Item> findByItemNameLike(@Param("itemName") String itemName);
	
	/*@Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
	Collection<Item> graph(@Param("limit") int limit);*/
}
