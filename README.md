# Routes:

## GET /produits
Récupère la liste de tout les produits

Sortie:
```
[
    {
        "id": long,
        "nom": string,
        "description": string,
        "prix": long
    }
]
```


## GET /produits/:id
Récupère un produit par son id

Sortie:
```
{
    "id": long,
    "nom": string,
    "description": string,
    "prix": long
}
```

## PUT /produits
Créer ou modifie un produit si l'id est déjà existant

Entrée dans le body / Sortie:
```
{
    "id": long,
    "nom": string,
    "description": string,
    "prix": long
}
```


## DELETE /produits/:id
Supprime un produit par son id

Sortie:
Code 404 si le produit n'existe pas
Code 200 si le produit a été supprimé