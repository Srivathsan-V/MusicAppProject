package com.example.demo.DTO;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.Artists;

public class SongsDto {
	private String songname;
	private String date_of_release;
	private String cover_image;
	private int avg_rating;
	private Set<Artists> artists = new HashSet<>();
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getDate_of_release() {
		return date_of_release;
	}
	public void setDate_of_release(String date_of_release) {
		this.date_of_release = date_of_release;
	}
	public String getCover_image() {
		return cover_image;
	}
	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}
	public int getAvg_rating() {
		return avg_rating;
	}
	public void setAvg_rating(int avg_rating) {
		this.avg_rating = avg_rating;
	}
	public Set<Artists> getArtists() {
		return artists;
	}
	public void setArtists(Set<Artists> artists) {
		this.artists = artists;
	}

}
