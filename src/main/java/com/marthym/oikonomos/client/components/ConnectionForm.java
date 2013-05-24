package com.marthym.oikonomos.client.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTML;
import com.marthym.oikonomos.client.i18n.OikonomosConstants;
import com.marthym.oikonomos.client.resources.WelcomeFormsRessource;

public class ConnectionForm extends Composite {

	private static ConnectionFormUiBinder uiBinder = GWT.create(ConnectionFormUiBinder.class);

	interface ConnectionFormUiBinder extends UiBinder<Widget, ConnectionForm> {}

	@UiField TextBox email;
	@UiField PasswordTextBox password;
	@UiField Button btnConnect;
	@UiField HTML errorHandler;
	
	public ConnectionForm() {
		initWidget(uiBinder.createAndBindUi(this));
		WelcomeFormsRessource.INSTANCE.style().ensureInjected();
		
		OikonomosConstants constants = (OikonomosConstants) GWT.create(OikonomosConstants.class);

		email.getElement().setAttribute("placeholder", constants.email());
		password.getElement().setAttribute("placeholder", constants.password());
	}

	@UiHandler("btnConnect")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

}
