package com.bruno.library.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Book implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String Title;
	
	@Column
	private String Subtitle;
	
	@Column
	private String Autor;
	
	@Column
	private String Publisher;
	
	@Column
	private String Year;
	
	@Column
	private String ReadYear;
	
	@Column(nullable = true)
	private String Favourite;
	
	
	protected Book() {}
	
	public Book(String Title, String Subtitle, String Autor, String Publisher, String Year, String ReadYear) {
		this.Title = Title;
		this.Subtitle = Subtitle;
		this.Autor = Autor;
		this.Publisher = Publisher;
		this.Year = Year;
		this.ReadYear = ReadYear;
	}

	@Override
	public String toString() {
		return " {" +
             
                "  Title='" + Title + '\'' +
                ", Subtitle='" + Subtitle + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Publisher=" + Publisher +
                ", Year='" + Year + '\'' +
                ", ReadYear='" + ReadYear +  
                '}';
		
	}
	
	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return Title;
	}

	public String getSubtitle() {
		return Subtitle;
	}

	public String getAutor() {
		return Autor;
	}

	public String getPublisher() {
		return Publisher;
	}

	public String getYear() {
		return Year;
	}

	public String getReadYear() {
		return ReadYear;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setSubtitle(String subtitle) {
		Subtitle = subtitle;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public void setYear(String year) {
		Year = year;
	}

	public void setReadYear(String readYear) {
		ReadYear = readYear;
	}
	
}
