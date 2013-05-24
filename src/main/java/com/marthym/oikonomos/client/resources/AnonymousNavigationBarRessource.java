package com.marthym.oikonomos.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AnonymousNavigationBarRessource extends ClientBundle {
	public AnonymousNavigationBarRessource INSTANCE = GWT.create(AnonymousNavigationBarRessource.class);
	
	public interface AnonymousNavigationBarCss extends CssResource {
	      String navAnonymous();
	      String focus();
	   }

	   @Source("AnonymousNavigationBar.css")
	   AnonymousNavigationBarCss style();
}
