package com.example.demo.DTO;
import java.util.HashSet;
import java.util.Set;
import com.example.demo.entity.Songs;
public class ArtistDto {
	 private String name;
	 private String dob;
	 private String bio;
	 private Set<Songs> songs = new HashSet<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public Set<Songs> getSongs() {
		return songs;
	}
	public void setSongs(Set<Songs> songs) {
		this.songs = songs;
	}
	 
	}


