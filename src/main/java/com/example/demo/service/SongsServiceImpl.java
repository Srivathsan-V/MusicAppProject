package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ArtistDto;
import com.example.demo.DTO.SongsDto;
import com.example.demo.entity.Artists;
import com.example.demo.entity.Songs;
import com.example.demo.repository.SongsRepository;

@Service
@Transactional
public class SongsServiceImpl implements SongsService {
	@Autowired
	private SongsRepository songrepo;
	
	@Override
	public List<Songs> findAllOrderByAvg_ratingDesc() {
        return songrepo.findAllOrderByAvg_ratingDesc();
		
    }
	@Override
	public List<SongsDto> getAllsongswithArtists(){
		List<Songs> allsongs = songrepo.findAllOrderByAvg_ratingDesc();
		List<SongsDto> songDtos = new ArrayList<>();
        allsongs.stream().forEach(song -> {
            SongsDto songDto = mapsongEntityToDto(song);
            songDtos.add(songDto);
        });
        return songDtos;
		
		
	}
	private SongsDto mapsongEntityToDto(Songs song) {
        SongsDto responseDto = new SongsDto();
        Set<Artists> finalset = new HashSet<>();
        responseDto.setSongname(song.getSongname());
        responseDto.setDate_of_release(song.getDate_of_release());
        responseDto.setCover_image(song.getCover_image());
        responseDto.setAvg_rating(song.getAvg_rating());
        
        for(Artists a : song.getArtists()) {
        	finalset.add(a);
        }
        responseDto.setArtists(finalset);
        //responseDto.setSongs(artist.getSongs().stream().map(Songs::getSongname).collect(Collectors.toSet()));        
        return responseDto;
    }
	
	@Override
	public Songs findSong(String name) {
	    return songrepo.findById(name).orElse(new Songs());
	}
	

}
