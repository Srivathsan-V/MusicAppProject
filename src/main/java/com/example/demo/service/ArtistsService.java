package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.ArtistDto;
import com.example.demo.entity.Artists;
import com.example.demo.entity.Songs;


public interface ArtistsService {
	//public List<Artists> viewAllArtists();
	//public Artists addArtist(Artistdto artiststdto);
	public ArtistDto addArtist(ArtistDto artistDto);
    public List<ArtistDto> getAllArtist();
	//public Optional<Artists> findBysongname(String name);
    public List<Artists> findBysongname(String name);





}
