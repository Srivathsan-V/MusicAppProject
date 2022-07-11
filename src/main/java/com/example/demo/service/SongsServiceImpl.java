package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Songs findSong(String name) {
	    return songrepo.findById(name).orElse(new Songs());
	}
	

}
