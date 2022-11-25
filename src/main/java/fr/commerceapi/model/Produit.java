package fr.commerceapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "produit")
@Getter
@Setter
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "nom")
    private String nom;

	@Column(name = "description")
    private String description;
    @Column(name = "prix")
	private double prix;

	public Produit() {
    }



}
