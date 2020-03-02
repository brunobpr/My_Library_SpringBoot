package com.bruno.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
import com.bruno.library.domain.Book;
import com.bruno.library.repo.BookRepository;
import com.bruno.library.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	
	@Autowired
	BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	public void run(String... args) throws Exception {
		createBooks("book.json");
		long numOfBook = bookService.total();
	}

	private void createBooks(String nameOfTheFile) throws IOException {
		BookFromFile.read(nameOfTheFile).forEach(importedBook -> bookService.createBook(
				importedBook.getTitle(),
				importedBook.getSubtitle(),
				importedBook.getAutor(), 
				importedBook.getPublisher(), 
				importedBook.getYear(), 
				importedBook.getReadYear()));
	}


	 private static class BookFromFile {
	        //fields
	        private String Title, Subtitle, Autor, Publisher, Year, ReadYear;
	        //reader
	        static List<BookFromFile> read(String nameOfTheFile) throws IOException {
	            return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).setVisibility(FIELD, ANY).
	                    readValue(new FileInputStream(nameOfTheFile), new TypeReference<List<BookFromFile>>() {});
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
			protected BookFromFile(){}
	        
	        
	 }
	
}
