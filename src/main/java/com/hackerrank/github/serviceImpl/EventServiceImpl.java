package com.hackerrank.github.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.repository.RepoRepository;
import com.hackerrank.github.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private RepoRepository repoRepository;

	public void deleteAll() {
		eventRepository.deleteAll();
	}

	public Long addNewEvent(Event event) {
		Event newEvent = eventRepository.save(event);
		System.out.println(newEvent.toString());
		return newEvent.getId();
	}

	public List<Event> getAllEvents() {

		return (List<Event>) eventRepository.findAll();
	}

	public List<Event> getEventsByActorID(long ID) {

		return eventRepository.findByActorIdOrderByIdAsc(ID);

	}

	public List<Event> getEventsByRepoID(long repoID) {

		return eventRepository.findByRepoIdOrderByIdAsc(repoID);

	}

	public Optional<Event> getEventByEventID(long eventID) {

		return eventRepository.findById(eventID);

	}

	public List<Event> getAllEventsByRepoIdAndActorId(Long repoId, Long actorId) {
		return eventRepository.findAllEventsByRepoIdAndActorId(repoId, actorId);
	}
}
