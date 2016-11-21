package se.kth.networking.java.fourth.ejb;

import se.kth.networking.java.fourth.ejb.remote.CurrencyBeanPersistenceRemote;
import se.kth.networking.java.fourth.entity.Currency;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.util.List;

/**
 * Created by Nick on 11/21/2016.
 */
@ManagedBean(name = "currencyBean", eager = true)
@SessionScoped
public class CurrencyMBean {
    @EJB
    CurrencyBeanPersistenceRemote currencyBean;
    Currency toCurrency;
    Currency fromCurrency;
    float amount;
    float result;

//    Currency selected;
    List<Currency> currencies;

    public CurrencyMBean() {
    }

//    public void setSelected(Currency selected) {
//        if (currencies == null) setCurrencies(null);
//        this.selected = selected;
//    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencyBean.getAllCurrencies();
    }

//    public SelectItem getCurrency() {
//        if (currencies == null) setCurrencies(null);
//        return new SelectItem(currencies.get(0).getId());
//    }

    public List<Currency> getCurrencies() {
        return currencyBean.getAllCurrencies();
    }

    public Currency getFromCurrency() {
        if (fromCurrency == null) return currencyBean.getAllCurrencies().get(0);
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        if (fromCurrency == null) return currencyBean.getAllCurrencies().get(0);
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public Object convert() {
        result = currencyBean.convert(fromCurrency, toCurrency, amount);
        return null;
    }
}
