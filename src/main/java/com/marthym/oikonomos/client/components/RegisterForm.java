package com.marthym.oikonomos.client.components;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.validation.client.impl.Validation;
import com.marthym.oikonomos.client.Oikonomos;
import com.marthym.oikonomos.client.i18n.OikonomosConstants;
import com.marthym.oikonomos.client.pages.WelcomePage.DeckWidgetIndex;
import com.marthym.oikonomos.client.resources.WelcomeFormsRessource;
import com.marthym.oikonomos.client.resources.WelcomeFormsRessource.WelcomeFormsCss;
import com.marthym.oikonomos.client.services.UserServiceAsync;
import com.marthym.oikonomos.shared.FieldVerifier;
import com.marthym.oikonomos.shared.model.User;

public class RegisterForm extends Composite {
	private static RegisterFormUiBinder uiBinder = GWT
			.create(RegisterFormUiBinder.class);

	interface RegisterFormUiBinder extends UiBinder<Widget, RegisterForm> {}

	@UiField TextBox email;
	@UiField TextBox lastname;
	@UiField TextBox firstname;
	@UiField PasswordTextBox password;
	@UiField PasswordTextBox passwordConfirm;
	@UiField Button btnRegister;
	
	private final WelcomeFormsCss css = WelcomeFormsRessource.INSTANCE.style();

	public RegisterForm() {
		OikonomosConstants constants = GWT.create(OikonomosConstants.class);
		css.ensureInjected();
		
		initWidget(uiBinder.createAndBindUi(this));
		email.getElement().setAttribute("placeholder", constants.email());
		lastname.getElement().setAttribute("placeholder", constants.lastname());
		firstname.getElement().setAttribute("placeholder", constants.firstname());
		password.getElement().setAttribute("placeholder", constants.password());
		passwordConfirm.getElement().setAttribute("placeholder", constants.passwordConfirm());
	}

	@UiHandler("btnRegister")
	void onClick(ClickEvent event) {
		User user = new User(email.getValue(), firstname.getValue(), lastname.getValue(), password.getValue(), new Date(), new Date());
		
		
		 Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
         Set<ConstraintViolation<User>> violations = validator.validate(user);
         if(!violations.isEmpty()){
             StringBuilder builder = new StringBuilder();
             for (ConstraintViolation<User> violation : violations) {
                 builder.append(violation.getMessage());
                 builder.append(" : <i>(");
                 builder.append(violation.getPropertyPath().toString());
                 builder.append(" = ");
                 builder.append("" + violation.getInvalidValue());
                 builder.append(")</i>");
                 builder.append("<br/>");
             }
             //Affiche un message d'erreur avec les contraintes non respectées
             Window.alert("Contraintes non respectées !\r" + builder.toString());
             return;
         }		
		
		final UserServiceAsync userService = UserServiceAsync.Util.getInstance();
		userService.saveUser(email.getValue(), firstname.getValue(), lastname.getValue(), password.getValue(), new Date(), new Date(), new AsyncCallback<Void>() {
				public void onFailure(Throwable caught) {
					Window.alert(caught.getClass()+": "+caught.getLocalizedMessage());
				}
				public void onSuccess(Void noAnswer) {
					Widget parent = getParent();
					
					if (Oikonomos.isAssignableFrom(parent, DeckLayoutPanel.class)) {
						((DeckLayoutPanel)parent).showWidget(DeckWidgetIndex.CONNECT_WIDGET.ordinal());
					}
				}
			});
	}

}
