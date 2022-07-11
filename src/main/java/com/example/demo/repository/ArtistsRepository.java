package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Artists;


	public interface ArtistsRepository extends JpaRepository<Artists, String>{
		//public Optional<Artists> findBysongname(String name);
	@Query("select a from Artists a join a.songs s where s.songname = :c")
	public List<Artists> findBysongname(@Param("c")String name);


}
