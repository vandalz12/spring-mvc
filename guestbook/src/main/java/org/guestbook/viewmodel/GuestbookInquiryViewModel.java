package org.guestbook.viewmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.guestbook.domain.Guest;
import org.guestbook.domain.GuestExample;
import org.guestbook.domain.GuestExample.Criteria;
import org.guestbook.util.Action;
import org.guestbook.util.GuestbookSpringUtil;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Window;

public class GuestbookInquiryViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7004055173946620199L;
	
	@Wire private Window winGuestbookInquiry;
	@Wire private Paging pagingGuestbook;
	
	private Guest guest = new Guest();
	private List<Guest> guests = new ArrayList<Guest>();
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
    }

	@Command
	@NotifyChange("guests")
	public void onFind() {
		resetObject();
		generateDataAndPaging();
	}
	
	@Command
	public void onNew() {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(Action.class.getName(), Action.NEW);
			Executions.createComponents("GuestSetup.zul", winGuestbookInquiry.getParent(), params);
		} finally {
			winGuestbookInquiry.detach();
		}
	}
	
	@Command
	@NotifyChange("guests")
	public void onPaging() {
		generateDataAndPaging();
	}
	
	@Command
	public void onDetail(@BindingParam("data") Guest guest) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(Action.class.getName(), Action.DETAIL);
			params.put(Guest.class.getName(), guest);
			Executions.createComponents("GuestSetup.zul", winGuestbookInquiry.getParent(), params);
		} finally {
			winGuestbookInquiry.detach();
		}
	}
	
	private void generateDataAndPaging() {
		GuestExample guestExample = new GuestExample();
		Criteria criteria = guestExample.createCriteria();
		if(guest.getGuestName() != null) {
			criteria.andGuestNameLikeInsensitive("%" + guest.getGuestName() + "%");
		}
		if(guest.getAddress() != null) {
			criteria.andAddressLikeInsensitive("%" + guest.getAddress() + "%");
		}
		pagingGuestbook.setTotalSize(GuestbookSpringUtil.getGuestbookServiceImpl().countGuest(guestExample));
		guests = GuestbookSpringUtil.getGuestbookServiceImpl().getGuest(guestExample, pagingGuestbook.getPageSize(), pagingGuestbook.getActivePage() * pagingGuestbook.getPageSize());
	}
	
	private void resetObject() {
		guests.clear();
		pagingGuestbook.setActivePage(0);
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}
	
}
