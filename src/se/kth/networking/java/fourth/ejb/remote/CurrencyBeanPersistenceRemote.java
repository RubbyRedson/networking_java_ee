package se.kth.networking.java.fourth.ejb.remote;

import se.kth.networking.java.fourth.entity.Currency;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Nick on 11/21/2016.
 */
@Remote
public interface CurrencyBeanPersistenceRemote {
    public List<Currency> getAllCurrencies();
    public Currency getByCountryCode(String s);
    public int convert(String from, String to, float amount);
}
