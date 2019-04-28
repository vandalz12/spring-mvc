package org.guestbook.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;
import org.guestbook.dao.GuestMapper;
import org.guestbook.domain.Guest;
import org.guestbook.domain.GuestExample;
import org.guestbook.service.GuestBookService;
import org.guestbook.util.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("guestbookServiceImpl")
public class GuestBookServiceImpl implements GuestBookService {
	
	@Autowired private GuestMapper guestMapper;
	
	@Transactional
	public void save(Guest guest, Action action) {
		if(action.equals(Action.NEW)) {
			guest.setGuestId(UUID.randomUUID().toString());
			guestMapper.insertSelective(guest);
		} else {
			guestMapper.updateByPrimaryKeySelective(guest);
		}
	}

	@Transactional(readOnly=true)
	public List<Guest> getGuest(GuestExample guestExample, int limit, int offset) {
		return guestMapper.selectByExampleWithRowbounds(guestExample, new RowBounds(offset, limit));
	}

	@Transactional(readOnly=true)
	public Guest getById(String guestId) {
		return guestMapper.selectByPrimaryKey(guestId);
	}

	@Transactional(readOnly=true)
	public int countGuest(GuestExample guestExample) {
		return guestMapper.countByExample(guestExample);
	}

}
