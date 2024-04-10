package com.tredence.assignment.external.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tredence.assignment.api.exception.SearchException;
import com.tredence.assignment.model.ExternalSearchResponse;

@RequestMapping("/external")
public interface IExternalSearch {
	
	@GetMapping(value = "/search")
	ResponseEntity<ExternalSearchResponse> searchExternalData(@RequestParam(name ="shopperId", required = true) String shopperId ,
			@RequestParam(name ="category", required = false) String category,@RequestParam(name ="brand", required = true) String brand,
			@RequestParam(name ="limit", required = true, defaultValue = "10") Integer limit) throws SearchException;
	
}
