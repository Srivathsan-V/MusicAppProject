package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;

@Entity
@Table
public class Artists {
	@Id
	private String name;
	
	@Column
	private String dob;
	public Set<Songs> getSongsset() {
		return songs;
	}
	public void setSongsset(Set<Songs> songsset) {
		this.songs = songsset;
	}
	@Column
	private String bio;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "ARTIST_SONGS", joinColumns = { @JoinColumn(name = "ARTIST_ID",referencedColumnName = "name") }, inverseJoinColumns = {
            @JoinColumn(name = "SONG_ID",referencedColumnName = "songname") })
    private Set<Songs> songs = new HashSet<>();
	
	public Artists() {
	}
	
	
	public Set<Songs> getSongs() {
		return songs;
	}
	public void setSongs(Set<Songs> songs) {
		this.songs = songs;
	}
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
	public void addSong(Songs song) {
		this.songs.add(song);
		song.getArtists().add(this);
	}
	 public void removeSong(Songs song) {
	        this.getSongsset().remove(song);
	        song.getArtists().remove(this);
	    }
	    public void removeSongs() {
	        for (Songs song : new HashSet<>(songs)) {
	            removeSong(song);
	        }
	    }

}
