------------------------------------------------------------------------

![](/Users/marc/Documents/School/A2022/TDinf2010/TP4-Draft/TP4Draft/Ressource/logo_poly.png)
<td><h1>INF2010 - Structures de données et algorithmes</h1></td>

Merci au cours INF3500 pour le format du Markdown

------------------------------------------------------------------------

Travail pratique \#4
====================

Heap et Fils de priorité
=============================================================

Objectifs
---------
* Comprendre et implémenter un Max et Min Heap

* Création et compréhension d'un heap sort

* Utilisation et compréhension de la théorie des fils de priorité

Préparation au laboratoire
--------------------------
Pour ce laboratoire, il est recommandé d’utiliser l’[IDE IntelliJ](https://www.jetbrains.com/fr-fr/idea/download/)
offert par JetBrains. Vous avez accès à la version complète (Ultimate) en tant qu’étudiant à Polytechnique Montréal.
Il suffit de vous créer un compte étudiant en remplissant le [formulaire d'inscription étudiante](https://www.jetbrains.com/shop/eform/students).


Astuces
-------
### Gradle
Le projet utilise Gradle pour gérer les *builds*. Après ouverture du projet, il est nécessaire d'importer le projet
Gradle à l'aide d'une fenêtre qui apparaîtra en bas à droite de votre écran.

Dans le cadre du laboratoire, les différentes *build configurations* nous permettront de générer des programmes
contenant les tests implémentés à l'aide de [JUnit](https://junit.org/junit5/).

### Configuration Java
Afin que le TP compile sans erreurs, vous devez vous assurer d'utiliser la version 17 de Java SDK.
Pour ce faire aller dans File -> Project Structure. Ensuite, sous project SDK assurez-vous d'avoir
openjdk-17. Il est possible de l'installer avec Intellij en ouvrant le *dropdown* SDK puis en allant sur *Add SDK* et en cliquant sur *Download SDK*. Vous devrez aussi
sélectionner **15-Text blocks** comme **Project language level**.

### Java

Pour ce laboratoire, il est suggéré d'apprendre à utiliser les `streams` de Java. Vous pouvez trouver plus d'information
[ici](https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/). À noter que tout le laboratoire peut très
bien se réaliser sans ceux-ci.

------------------------------------------------------------------------

Partie 1 : Comprendre et implémenter un Max/Min heap 
---------------
Comme dans les TP précédant, vous devez utiliser implémenter une classe **Heap** générique. 
Cette classe doit pouvoir accommodé les 2 types de Heap possible, soit Max heap et Min heap. Pour ce faire, le constructeur 
devra avoir un champ booléan qui suit la règle suivante:

1. Si le booléan est vrai, il s'agit d'un Max heap
2. Si le booléan est faux, il s'agit d'un Min heap
3. Si aucun booléan est fourni, il faut créer un Max heap


Quelques fonctions qui doivent être implémenté sont **constructeur, heapify, insert et delete**. 
Vous pouvez créer autant de fonction que vous voulez pour vous aider dans l'implémentation.

**ATTENTION!! Toutes fonctions qui ne possèdent pas d'en-tête seront ignoré! Si le code ne fonctionne pas
après avoir ignoré ces fonction, vous perdrez tous les points**

Vous pouvez utiliser les en-têtes des TP précédent comme référence. IntelliJ offre un auto fill pour les 

Les complexités seront évaluées:
1. insert et delete ne doit pas dépasser O (Log n)
2. Heapify ne doit pas dépasser O (n)

**Formules à connaître:**
1. Enfant gauche est à 2i où i est le parent
2. Enfant droite est à 2i + 1 où i est le parent

------------------------------------------------------------------------
Partie 2: Heap Sort
---------------

Heap sort est un simple tri d'élément d'un array grâce au notion de max et min heap. Puisque les éléments sont trié de sorte
que l'élement le plus grand (dans le cas d'un max heap) est à la première position (root) et le delete enlève seulement le premier élément.

Dans cette partie, vous devez faire un heap sort sur les arrays générés. En premier lieu,
vous devez générer 3 arrays de 25 éléments qui contiennent des valeurs aléatoiresé (integer).
Ensuite, vous devez créer un Max heap pour chacun des array et donnée en paramètre le array. (Ne pas utiliser insert).
Les heap doivent retourner un array qui est trié.


Vous devez utiliser la classe que vous avez créée. 
**L'utilisation d'une autre classe de Java ne sera pas acceptée.**


---
Partie 3 : Utilisation et compréhension des fils de priorité
---------------

Les fils de priorité sont souvent utilisé pour résoudre des problèmes qui semblent très complexe. Par exemple, lors des
entrevues que vous allez effectuer auprès des entreprises, vous allez peut-être demander de résoudre des problèmes en 1h.

Dans cette partie, vous devez résoudre 2 version d'un problèmes qui peuvent vous être demandé lors des entrevues. Ces problèmes sont
peut-être difficiles à résoudre sans l'utilisation de Heap, mais, grâce aux Heap, ils sont faciles à résoudre.

**Trouver le K ième élément**

Vous devez implémenter une ou plusieurs fonctions/classes qui permettent de résoudre ces 2 cas:
1. Un array de N int est donné en paramètre avec un int K qui va être entre 1 et N (Vous n'êtes pas obligé de faire cette vérification, mais vous devez l'ajuster pour ne pas obtenir une exception).
2. Un array de M String est donné en paramètre et un int Q qui va être entre 1 et M. L'importance des string est selon la fréquence de la lettre "a" (Minuscule) dans le string.

K et Q représente les rangs à partir du MAX. Par exemple, si K = 3, on demande le 3 ième élément le plus grand du array.

Exemple:

[1,1,1,1,2,3,4,5,5,6,7,8,9,9,9] Si K = 2, Le heap retourne 9

["aaa", "abc", "aab", "AaAb", "zsw" ] Si Q = 2, le heap retourne "aab"

L'évaluation sera fait avec 2 arrays de plus grande taille.

**Vous devez utiliser votre Heap**
Vous devez créer une classe générique qui sera utilisé pour les 2 cas.

Barème de correction
--------------------

|                               |     |
|-------------------------------|-----|
| Partie 1                      | /10 |
| Partie 2                      | /5  |
| Partie 3                      | /5  |
| Qualité du code (-0.5/erreur) |     |

##### Qu'est-ce que du code de qualité ?
* Absence de code dédoublé (FAITES DES FONCTIONS!!!)
* Absence de *warnings* à la compilation
* Absence de code mort : Code en commentaire, variable inutilisé, etc...
* Respecte les mêmes conventions de codage dans tout le code produit
    * Langue utilisée
    * Noms des variables, fonctions et classes
* Variables, fonctions et classes avec des noms pertinents et clairs qui expliquent leur intention et non leur comportement
* La duré de vie des variables est justifiée. (Ne pas déclarer les index des FOR loop avant les boucles si elles ne sont pas utilisées après les boucles)
* Pas de code du type :
```java
class Example {
  //Exemple de mauvais code
  private static boolean foo(Integer x) {
    if (x > 10)
      return true;
    else
      return false;
  }

  //Exemple de bon code
  private static boolean foo(Integer x) {
    return x > 10;
  }
}
```
**Petite astuce:** Utiliser les fonctionnalités offertes par Intellij!



Le dernier commit de votre répertoire sera utilisé comme remise finale. Chaque jour de retard créera une pénalité
additionnelle de 20 %. Aucun travail ne sera accepté après 4 jours de retard.

