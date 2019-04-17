package org.rest.v2.controller;

import java.net.URI;
import java.util.Optional;

import org.rest.domain.Poll;
import org.rest.dto.error.ErrorDetail;
import org.rest.exception.ResourceNotFoundException;
import org.rest.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("pollControllerV2")
@RequestMapping(value = "v2")
@Api(tags = "polls", description = "Poll API")
public class PollController {

	@Autowired private PollRepository pollRepository;
	
	@RequestMapping(value = "polls", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Retrive all polls", response = Poll.class, responseContainer = "List")
	public ResponseEntity<Iterable<Poll>> getAllPolls() {
		Iterable<Poll> allPolls = pollRepository.findAll();
		
		return new ResponseEntity<Iterable<Poll>>(allPolls, HttpStatus.OK);
	}
	
	@RequestMapping(value = "polls", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Create a new poll", notes = "The newly created poll Id will be sent in the location response header", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Poll Created Successfully", response = Void.class),
			@ApiResponse(code = 500, message = "Error creating poll", response = ErrorDetail.class)
	})
	public ResponseEntity<Void> createPoll(@RequestBody Poll poll) {
		poll = pollRepository.save(poll);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(poll.getId()).toUri();
		responseHeaders.setLocation(newPollUri);
		return new ResponseEntity<Void>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/polls/{pollId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Retrieve a Poll associated with the pollId", response = Poll.class)
	public ResponseEntity<Poll> getPoll(@PathVariable Long pollId) {
		Optional<Poll> poll = pollRepository.findById(pollId);
		if(!poll.isPresent()) {
			throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
		}
		return new ResponseEntity<Poll>(poll.get(), HttpStatus.OK);
	}
	
}
