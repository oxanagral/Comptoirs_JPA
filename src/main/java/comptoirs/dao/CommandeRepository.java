package comptoirs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import comptoirs.entity.Commande;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    @Query(
            // Chaîne de caractères multilignes
            """
             SELECT SUM(l.quantite * l.produit.prixUnitaire *(1-Commande.remise))
             FROM Commande
             JOIN Commande.lignes l
             WHERE Commande.numero = :numeroCommmande
            """)

/**
 * Calcule le montant des articles commandés dans une commande
 * @param numeroCommande le numéro de la commande à traiter
 * @return le montant des articles commandés, en tenant compte de la remise
 */
    BigDecimal montantArticles(Integer numeroCommande);

}
