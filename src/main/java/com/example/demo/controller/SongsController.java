package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.SongsDto;
import com.example.demo.entity.Songs;
import com.example.demo.repository.SongsRepository;
import com.example.demo.service.SongsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/songscontroller")
public class SongsController {
	@Autowired
	private SongsRepository songsrepo;
	@Autowired
	private SongsService songsservice;
	
	private EntityManager entitymanager;
	
	//get all songs
	@GetMapping("/viewsongs")
	public List<SongsDto> getAllSongs(){
		//return songsservice.findAllOrderByAvg_ratingDesc();
		return songsservice.getAllsongswithArtists();
		
	}
	
	@PostMapping("/addsongs")
	public void addsongs(@RequestBody Songs nsong1) {
		//Songs song1 = new Songs("Sorry","2022-03-21","img1",4);
		//Songs song2 = new Songs("Baby","2022-03-21","img1",4);
		//Songs song3 = new Songs("Say you won't let go","2022-03-21","img1",4);
		//entitymanager.persist(song1);
		//entitymanager.persist(song2);
		//entitymanager.persist(song3);
		songsrepo.save(nsong1);
		
	}

}
