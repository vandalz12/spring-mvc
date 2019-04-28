package org.guestbook.util;

import org.guestbook.service.GuestBookService;

public class GuestbookSpringUtil {

	public static GuestBookService getGuestbookServiceImpl() {
		return (GuestBookService) SpringContextUtil.getApplicationContext().getBean("guestbookServiceImpl");
	}
	
	
}
