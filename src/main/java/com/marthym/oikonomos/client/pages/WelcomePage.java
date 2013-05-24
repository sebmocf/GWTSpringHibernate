package com.marthym.oikonomos.client.pages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.marthym.oikonomos.client.components.AnonymousNavigationBar;

public class WelcomePage extends Composite {
	public static enum DeckWidgetIndex {CONNECT_WIDGET, REGISTER_WIDGET}
	
	private static WelcomePageUiBinder uiBinder = GWT.create(WelcomePageUiBinder.class);

	interface WelcomePageUiBinder extends UiBinder<Widget, WelcomePage> {}

	@UiField AnonymousNavigationBar navigationBar;
	@UiField DeckLayoutPanel deck;
	
	public WelcomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		
		navigationBar.addConnectHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				deck.showWidget(DeckWidgetIndex.CONNECT_WIDGET.ordinal());
			}
		});
		
		navigationBar.addRegisterHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				deck.showWidget(DeckWidgetIndex.REGISTER_WIDGET.ordinal());
			}
		});
		
		deck.showWidget(DeckWidgetIndex.CONNECT_WIDGET.ordinal());
	}
}
