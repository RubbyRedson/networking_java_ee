package se.kth.networking.java.fourth.ejb.local;

import se.kth.networking.java.fourth.ejb.remote.CurrencyBeanPersistenceRemote;
import se.kth.networking.java.fourth.entity.Currency;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 11/21/2016.
 */
@Stateless
public class CurrencyBeanPersistenceLocal implements CurrencyBeanPersistenceRemote {
//    @PersistenceContext(unitName="Cabbage")
//    EntityManager em;

    public int convert(String from, String to, float amount) {
        System.out.println(from + " " + to + " " + amount);
        return 42;
    }

    public List<Currency> getAllCurrencies() {
//        Query query = em.createNamedQuery("Currency.getAll");
//        return query.getResultList();

        List<Currency> dummy = new ArrayList<>();
        Currency dum1 = new Currency();
        dum1.setId("EUR");
        dum1.setWorth("2.0");
        dummy.add(dum1);
        Currency dum2 = new Currency();
        dum2.setId("USD");
        dum2.setWorth("1.0");
        dummy.add(dum2);
        Currency dum3 = new Currency();
        dum3.setId("SEK");
        dum3.setWorth("7.0");
        dummy.add(dum3);
        return dummy;
    }

    @Override
    public Currency getByCountryCode(String s) {
        Currency dum1 = new Currency();
        dum1.setId("SEK");
        dum1.setWorth("7.0");
        return dum1;
    }
}
