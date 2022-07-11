package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ArtistDto;
import com.example.demo.entity.Artists;
import com.example.demo.entity.Songs;
import com.example.demo.repository.ArtistsRepository;
import com.example.demo.repository.SongsRepository;

@Service
@Transactional
public class ArtistsServiceImpl implements ArtistsService {
	
	@Autowired
	private ArtistsRepository artistrepo;
	@Autowired
	private SongsRepository songsrepo;
	@Autowired
	private SongsService songservice;
	@Override
	public ArtistDto addArtist(ArtistDto artistDto) {
		Artists artist = new Artists();
        mapDtoToEntity(artistDto, artist);
        Artists savedArtist = artistrepo.save(artist);
        return mapEntityToDto(savedArtist);
	}
	//@Override
	//public Optional<Artists> findBysongname(String name) {
	    //return artistrepo.findById(name);
	@Override
	public List<Artists> findBysongname(String name) {
		// TODO Auto-generated method stub
		
		
		List<Artists> artistname= artistrepo.findBysongname(name);
		   //if(artistname!=null)
			   //return "Customer not Found";
		return artistname;
	}
    @Override   
    public List<ArtistDto> getAllArtist() {
            List<ArtistDto> artistDtos = new ArrayList<>();
            List<Artists> artists = artistrepo.findAll();
            artists.stream().forEach(artist -> {
                ArtistDto artistDto = mapEntityToDto(artist);
                artistDtos.add(artistDto);
            });
            return artistDtos;
  
		
	}
    private void mapDtoToEntity(ArtistDto artistDto, Artists artist) {
        artist.setName(artistDto.getName());
        artist.setDob(artistDto.getDob());
        artist.setBio(artistDto.getBio());
        if (null == artist.getSongs()) {
            artist.setSongs(new HashSet<>());
        }
        artistDto.getSongs().stream().forEach(songname -> {
            Songs song = songsrepo.findBysongname(songname.getSongname());
            if (null == song) {
                song = new Songs();
                song.setArtists(new HashSet<>());
            }
            song.setSongname(songname.getSongname());
            song.setDate_of_release(songname.getDate_of_release());
            song.setCover_image(songname.getCover_image());
            song.setAvg_rating(songname.getAvg_rating());
            artist.addSong(song);
        });
    }
    private ArtistDto mapEntityToDto(Artists artist) {
        ArtistDto responseDto = new ArtistDto();
        Set<Songs> finalset = new HashSet<>();
        responseDto.setName(artist.getName());
        responseDto.setDob(artist.getDob());
        responseDto.setBio(artist.getBio());
        
        for(Songs s : artist.getSongs()) {
        	finalset.add(s);
        }
        responseDto.setSongs(finalset);
        //responseDto.setSongs(artist.getSongs().stream().map(Songs::getSongname).collect(Collectors.toSet()));        
        return responseDto;
    }
		
	}


