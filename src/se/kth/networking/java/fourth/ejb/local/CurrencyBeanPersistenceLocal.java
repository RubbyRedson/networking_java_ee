package se.kth.networking.java.fourth.ejb.local;

import se.kth.networking.java.fourth.ejb.remote.CurrencyBeanPersistenceRemote;
import se.kth.networking.java.fourth.entity.Currency;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Nick on 11/21/2016.
 */
@Stateless
public class CurrencyBeanPersistenceLocal implements CurrencyBeanPersistenceRemote {
    @PersistenceContext(unitName = "Cabbage")
    EntityManager em;

    public float convert(String from, String to, float amount) {
        Currency fromC = getByCountryCode(from);
        Currency toC = getByCountryCode(to);

        float fromW = Float.parseFloat(fromC.getWorth());
        float toW = Float.parseFloat(toC.getWorth());

        float usd = amount / fromW;

        return usd * toW;
    }

    public List<Currency> getAllCurrencies() {
        Query query = em.createNamedQuery("Currency.getAll");
        return query.getResultList();
    }

    public Currency getByCountryCode(String s) {
        Query query = em.createNamedQuery("Currency.getByCountryCode");
        return (Currency) query.setParameter(1, s).getSingleResult();
    }
}
