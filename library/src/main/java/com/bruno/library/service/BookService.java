package com.bruno.library.service;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.library.domain.Book;
import com.bruno.library.repo.BookRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	/**
	 * @param Title
	 * @param Subtitle
	 * @param Autor
	 * @param Publisher
	 * @param Year
	 * @param ReadYear
	 * @return
	 */
	public Book createBook(String Title, String Subtitle, String Autor, String Publisher, String Year, String ReadYear) {
		return bookRepository.save(new Book(Title, Subtitle, Autor, Publisher, Year, ReadYear));
	}
	
	
	public long total() {
		return bookRepository.count();
	}
	
	
}
