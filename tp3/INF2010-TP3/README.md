------------------------------------------------------------------------

![](resources/logo_poly.png)
<td><h1>INF2010 - Structures de données et algorithmes</h1></td>

Merci au cours INF3500 pour le format du Markdown

------------------------------------------------------------------------

Travail pratique \#3
====================

Arbre Binaire de recherche
=============================================================

Objectifs
---------
* Apprendre le fonctionnement d’un arbre binaire de recherche

* Comprendre la complexité asymptotique d’un arbre binaire de recherche

* Utiliser les concepts associés aux arbres binaires dans des analyses de complexité

Astuces
-------
Veuillez consulter la section **Astuces** du README du travail pratique 1 pour la configuration du projet.

------------------------------------------------------------------------

Partie 1 : Implémentation des arbres binaires de recherche BST et AVL
---------------
Un arbre AVL est un arbre binaire de recherche équilibré. Celui-ci oblige que la différence entre la hauteur gauche et la hauteur droite soit inférieure à 2. Si cette condition n’est pas respectée, il vous faut rééquilibrer l’arbre avec l’algorithme des arbres AVL. Dans le cas du retrait d’un élément, une démarche spécifique doit être utilisée.

L'implémentation de ces algorithmes est disponible dans les diapositives **Cours05** et **Cours06** et dans le chapitre 4 du livre de Mark Allen Weiss.

Pour la première partie, il vous est demandé de compléter les classes BinaryTree, BinarySearchTree et AvlTree.

Il est possible de rouler le test AVLTreeTester pour afficher les parcours des arbres en préordre, en ordre et par niveau. Ce n'est que 2 tests case pour débuter, mais il est fortement encouragé d'en écrire plus pour vérifier le bon comportement de vos méthodes.

**ATTENTION : Une note de 0 sera automatiquement attribuée si vous utilisez un arbre binaire d’une librairie quelconque.**

------------------------------------------------------------------------

Partie 2 : Analyse en cas moyen
---------------
Pour la deuxième partie, on vous demande d'implémenter des compteurs d'opérations pour l'insertion et la recherche. Ces compteurs doivent être initialisés à la création des arbres BST et AVL et incrémentés selon l'opération. 

Vous devez par la suite générer des données aléatoires de différentes tailles et effectuer les opérations mentionnées plus haut.

Le travail d'analyse consiste à générer des graphiques de comparaison (BST vs AVL) pour chacune des opérations (insertion et recherche).

L'axe des y correspond à la valeur du compteur et l'axe des x correspond à la taille de l'arbre (nombre de nœuds).

Rédiger une analyse des résultats obtenus en mentionnant l'ordre des complexités.

Quel arbre est le plus rapide? 

Est-ce que les résultats obtenus sont cohérents avec la littérature?

------------------------------------------------------------------------

Partie 3 : Analyse en pire cas
---------------
Pour la troisième partie, on vous demande de comparer les compteurs d'insertion de chacun des arbres (BST vs AVL) pour un Worst case.

Vous devez générer un graphique de comparaison, où l'axe des y correspond à la valeur du compteur d'insertion et l'axe des x correspond à la taille de l'arbre (nombre de nœuds).

Rédiger une analyse des résultats obtenus en mentionnant l'ordre des complexités.

Quel arbre est le plus rapide? 

Est-ce que les résultats obtenus sont cohérents avec la littérature?

------------------------------------------------------------------------

La remise
---------------
La remise doit contenir les fichiers java complétés, les fichiers de générations des données et un rapport PDF contenant les graphiques et les analyses.

------------------------------------------------------------------------

Barème de correction
--------------------

||||
|-----------------|------------------------------------------|-----|
| Partie 1        | Implémentation des classes               | /6  |
|                 | Qualité du code                          | /2  |
| Partie 2        | Implémentation des compteurs             | /2  |
|                 | Génération des graphiques                | /2  |
|                 | Qualité de l'analyse et justification    | /3  |
| Partie 3        | Génération des graphiques                | /2  |
|                 | Qualité de l'analyse et justification    | /3  |
| Total           |                                          | /20 |


##### Qu'est-ce que du code de qualité ?
Consulter ce lien pour des détails sur les bonnes pratiques: https://drive.google.com/drive/folders/14RHZZgxQx5ftTdNwSdQGOWYrXxmB6s3r?usp=sharing
* Absence de code dédoublé (FAITES DES FONCTIONS!!!)
* Absence de *warnings* à la compilation
* Absence de code mort : Code en commentaire, variable inutilisé, etc...
* Respecte les mêmes conventions de codage dans tout le code produit
  * Langue utilisée
  * Noms des variables, fonctions et classes
* Variables, fonctions et classes avec des noms pertinents et clairs qui expliquent leur intention et non leur comportement

**Petite astuce:** Utiliser les fonctionnalités offertes par IntelliJ!

Le dernier commit de votre répertoire sera utilisé comme remise finale. Chaque jour de retard créera une pénalité
additionnelle de 20 %. Aucun travail ne sera accepté après 4 jours de retard.

**Date de remise: Dimanche 6 mars, 23h59**

