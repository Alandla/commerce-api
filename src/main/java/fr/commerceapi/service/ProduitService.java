package fr.commerceapi.service;

import fr.commerceapi.DAO.ProduitDAO;
import fr.commerceapi.model.Produit;
import fr.commerceapi.model.StockApiHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitDAO produitDAO;

    public List<Produit> getAll() {
        return produitDAO.getAll();
    }

    public Produit getBydId(Long id) {
        return produitDAO.getById(id);
    }

    @Transactional
    public Produit updateStock(StockApiHolder apiHolder, Long id){
        boolean action = apiHolder.isAdd();
        int quantite = apiHolder.getQuantite();
        Produit produit = produitDAO.getById(id);
        if (action) {
            produit.setStock(produit.getStock() + quantite);
        } else {
            produit.setStock(produit.getStock() - quantite);
        }
        return this.update(produit);
    }

    @Transactional
    public Produit create(Produit produit) {
        return produitDAO.create(produit);
    }

    @Transactional
    public Produit update(Produit produit) {
        return produitDAO.update(produit);
    }

    @Transactional
    public boolean delete(Long id) {
        Produit produit = this.getBydId(id);
        if (null == produit) {
            return false;
        }
        produitDAO.remove(produit);
        return true;
    }

}
