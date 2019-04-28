package org.guestbook.service;

import java.util.List;

import org.guestbook.domain.Guest;
import org.guestbook.domain.GuestExample;
import org.guestbook.util.Action;

public interface GuestBookService {

	public void save(Guest guest, Action action);
	public int countGuest(GuestExample guestExample);
	public List<Guest> getGuest(GuestExample guestExample, int limit, int offset);
	public Guest getById(String guestId);
	
}
