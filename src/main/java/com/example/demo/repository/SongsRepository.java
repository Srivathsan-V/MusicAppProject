package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Songs;

public interface SongsRepository extends JpaRepository<Songs, String>{
    @Query(nativeQuery = true, value = "Select * from Songs Order by avg_rating DESC limit 10 ")
   public List<Songs> findAllOrderByAvg_ratingDesc();
   public Songs findBysongname(String songname);


}
