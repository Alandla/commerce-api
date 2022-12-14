package fr.commerceapi.controller;

import fr.commerceapi.model.Produit;
import fr.commerceapi.model.StockApiHolder;
import fr.commerceapi.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/produits")
@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAll() {
        return produitService.getAll();
    }

    @GetMapping("/{id}")
    public Produit getById(@PathVariable final Long id) {
        return produitService.getBydId(id);
    }

    @GetMapping("/code/{code}")
    public Produit getByCode(@PathVariable final String code) {
        return produitService.getByCode(code);
    }

    @PutMapping("/stock/{id}")
    public Produit updateStock(@RequestBody final StockApiHolder apiHolder, @PathVariable final Long id) {
        return this.produitService.updateStock(apiHolder, id);
    }

    @PutMapping
    public Produit createOrReplace(@RequestBody final Produit application) {

        if (null != application.getId() && application.getId() > 0) {
            this.produitService.update(application);
            return application;
        }

        application.setId(null);//On s'assure que l'id vaut null pour l'ajout en base de données
        return this.produitService.create(application);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable final long id) {

        boolean deleted = this.produitService.delete(id);

        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
