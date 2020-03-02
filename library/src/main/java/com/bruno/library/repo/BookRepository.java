package com.bruno.library.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import com.bruno.library.domain.*;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer>{

	
	
	Page <Book> findBookByTitle(@Param("Title") String Title, Pageable page);
	
	
	@Override
	@RestResource(exported = false)
	default void delete(Book arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll(Iterable<? extends Book> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteById(Integer arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
