package com.marthym.oikonomos.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface WelcomeFormsRessource extends ClientBundle {
	public WelcomeFormsRessource INSTANCE = GWT.create(WelcomeFormsRessource.class);
	
	public interface WelcomeFormsCss extends CssResource {
	      String error();
	      String login();
	      String register();
	   }

	   @Source("WelcomeForms.css")
	   WelcomeFormsCss style();
}
