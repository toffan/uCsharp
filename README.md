# uCsharp
Compilateur pour un sous ensemble du Csharp

## Participants
- Antoine Beyet
- Matthieu Daumas
- Volodia Laniel
- Benoit Lemarchand

#MicroC
##Fontionnalités
- Les opérations sur les entiers fonctionnent
- Récupération  de la valeur d'une affectation. On peut ainsi faire des affectiation en cascade
- Les déclarations et appels imbriqués de fonctions
- Les structs & les pointeurs
- La gestion des chaines de caractères est réalisée via une suite de caractères. Le code relatif aux strings est généré mais il n'a pas été testé car la machine TAM ne le supporte pas.
- La définition de types personnalisés
- Le casting statique entre types. On peut caster un type en un autre uniquement si les deux types ont la même taille.
- Lors de la compilation, le système de types loggue ses actions (tels les ajouts et recherches dans la TDS)

##Améliorations possibles & limitations
**Optimisation** 
- Il aurait été possible de faire des optimisations sur le code généré. Actuellement il n'y a aucun pré-calcul. Ainsi l'affectation a = 3+4 charge 3 puis 4 sur la pile et enfin somme les 2 termes. Cela pourrait être optimisé avec l'ajout d'un attribut constExpr qui indique si la valeur d'un facteur est connue à la compilation. Dans le cas d'une opération entre 2 consExpr valides, la valeur serait calculée à la compilation.

- Afin de pouvoir récuperer la valeur d'une affectation, celle-ci est dupliquée pour pouvoir être utilisée par la suite. Dans le cas où elle n'est pas utilisée, on pourrait éviter cette recopie.

- Lorsque l'on sort d'un  bloc if, on dépile les variables déclarées à l'intérieur de ce bloc, même s'il n'y en a aucune. On a alors un POP 0. Cette optimisation serait facile à mettre en place via un test sur la taille des variables.

**Limites** 
- Faire des opérations sur le resultat d'une fonction dans la même instruction que son utilisation n'est pas garanti. On pourrait cependant interdire cette opération dans la grammaire pour renforcer le langage. _Ex: lecture d'un champ d'un struct issu d'une fonction : int xx = retourneXY()->x +3;_

##Tests
Il est possible de tester la correction du code généré en exécutant la commande `make test`.

Les fichiers de tests sont dans le dossier _utests_. Les fichiers .mcs sont compilés en .tam puis sont comparés aux fichiers .expected (écrit manuellement). Les fichiers -wrong.mcs sont des fichiers mcs avec une syntaxe incorrecte et dont le résultat attendu est une erreur.

#Micro CSharp
