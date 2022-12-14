package fr.commerceapi.DAO;

import com.querydsl.jpa.impl.JPAQuery;
import fr.commerceapi.model.Produit;
import fr.commerceapi.model.QProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProduitDAO {

    @Autowired
    EntityManager entityManager;

    public List<Produit> getAll() {
        JPAQuery<Produit> query = new JPAQuery<>(entityManager);
        QProduit produit = QProduit.produit;
        return query.select(produit).from(produit).fetch();
    }

    public Produit getById(Long id) {
        JPAQuery<Produit> query = new JPAQuery<>(entityManager);
        QProduit produit = QProduit.produit;
        return query.select(produit).from(produit).where(produit.id.eq(id)).fetchOne();
    }

    public Produit getByCode(String code) {
        JPAQuery<Produit> query = new JPAQuery<>(entityManager);
        QProduit produit = QProduit.produit;
        return query.select(produit).from(produit).where(produit.code.eq(code)).fetchOne();
    }

    public Produit create(Produit produit) {
        this.entityManager.persist(produit);
        return produit;
    }

    public Produit update(Produit produit) {
        this.entityManager.merge(produit);
        return produit;
    }

    public void remove(Produit produit) {
        this.entityManager.remove(produit);
    }


}
