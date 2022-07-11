package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Songs {
	@Id
	private String songname;
	@Column
	private String date_of_release;
	@Column
	private String cover_image;
	@Column
	private int avg_rating;
	  @ManyToMany(mappedBy = "songs")
	    @JsonIgnore
	 private Set<Artists> artists = new HashSet<>();
	

	public Songs() {
	}
	
	

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
	public Set<Artists> getArtists() {
		return artists;
	}
	public void setArtists(Set<Artists> artists) {
		this.artists = artists;
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
	public void addartists(Artists artist) {
		this.artists.add(artist);
		
	}

}
