package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ArtistDto;
import com.example.demo.entity.Artists;
import com.example.demo.repository.ArtistsRepository;
import com.example.demo.service.ArtistsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/artistsController")
public class ArtistsController {
	@Autowired
	private ArtistsRepository artistsrepo;
	@Autowired
	private ArtistsService artistservice;
	
	//get all songs
	@GetMapping("/viewArtists")
	public List<Artists> getAllArtists(){
		return artistsrepo.findAll();
	}
	
	@PostMapping("/addArtists")
	public ArtistDto addartist(@RequestBody ArtistDto artistDto) {
		return artistservice.addArtist(artistDto);
	}
	@GetMapping("/viewArtist/{songname}")
	public ResponseEntity<List<Artists>> ViewAllArtists(@PathVariable String songname){
		List<Artists> artists=artistservice.findBysongname(songname);
		return new ResponseEntity(artists,HttpStatus.OK);
		}

}

