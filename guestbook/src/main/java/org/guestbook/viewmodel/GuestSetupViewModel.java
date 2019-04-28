package org.guestbook.viewmodel;

import java.io.Serializable;
import java.util.Map;

import org.guestbook.domain.Guest;
import org.guestbook.util.Action;
import org.guestbook.util.GuestbookSpringUtil;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class GuestSetupViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2283010046448610306L;

	@WireVariable
	private Map<String, Object> arg;
	
	@Wire private Window winGuestSetup;
	
	private Guest guest = new Guest();
	private Action action;
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        initParameters();
    }

	private void initParameters() {
		if(arg.containsKey(Action.class.getName())) {
			action = (Action) arg.get(Action.class.getName());
			if(action.equals(Action.DETAIL)) {
				guest = (Guest) arg.get(Guest.class.getName());
			}
		}
	}
	
	@Command
	public void onCancel() {
		try {
			Executions.createComponents("index.zul", winGuestSetup.getParent(), null);
		} finally {
			winGuestSetup.detach();
		}
	}
	
	@Command
	public void onSave() {
		Messagebox.show("Are You Sure Want to save this data", "Confirmation", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION, new SerializableEventListener<Event>() {

			private static final long serialVersionUID = 6618352783877947678L;

			public void onEvent(Event event) throws Exception {
				try {
					Integer resultButton = (Integer) event.getData();
					if(resultButton.equals(Messagebox.YES)) {
						GuestbookSpringUtil.getGuestbookServiceImpl().save(guest, action);
						onCancel();
					}
				} catch (Exception e) {
//					MessageboxUtils.showErrorWithException(Labels.getLabel("common.systemError"), Labels.getLabel("common.information"), Messagebox.ERROR, e, winUserSetup);
					e.printStackTrace();
				}
			}
		});
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
	
}
