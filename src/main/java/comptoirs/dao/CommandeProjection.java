package comptoirs.dao;

import java.math.BigDecimal;


 //vue simplifiée des commandes.

public interface CommandeProjection {

    Integer getNumero();

    String getPort();

    BigDecimal getMontantTotal();
}
