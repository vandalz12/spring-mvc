package org.guestbook.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.guestbook.domain.Guest;
import org.guestbook.service.GuestBookService;
import org.guestbook.util.Action;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

	
	@Autowired private GuestBookService guestBookService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void addUSer() {
		Guest guest = new Guest();
		guest.setGuestName("Guest Name Mock");
		guest.setAddress("Address Guest Name Mock");
		guest.setGuestDate(new Date());
		guestBookService.save(guest, Action.NEW);
		assertNotNull(guestBookService.getById(guest.getGuestId()));
	}
	
}
