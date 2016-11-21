package se.kth.networking.java.fourth.ejb;

import se.kth.networking.java.fourth.ejb.remote.CurrencyBeanPersistenceRemote;
import se.kth.networking.java.fourth.entity.Currency;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Created by Nick on 11/21/2016.
 */
@ManagedBean(name = "currencyConverter")
@RequestScoped
public class CurrencyConverter implements Converter {

    @EJB
    private CurrencyBeanPersistenceRemote currencyPersistance;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return currencyPersistance.getByCountryCode(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Country Code", submittedValue)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Currency) {
            return String.valueOf(((Currency) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Currency", modelValue)));
        }
    }

}