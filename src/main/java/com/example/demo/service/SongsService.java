package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.SongsDto;
import com.example.demo.entity.Artists;
import com.example.demo.entity.Songs;

public interface SongsService {
	
    public List<Songs> findAllOrderByAvg_ratingDesc();
    public Songs findSong(String name);
    public List<SongsDto> getAllsongswithArtists();
        

}
