# uCsharp
Compilateur pour un sous ensemble du Csharp

## Participants
- Antoine Beyet
- Matthieu Daumas
- Volodia Laniel
- Benoit Lemarchand

#MicroC
##Fontionnalités
- Les opérations sur les entiers fonctionnent. 
- récupération  de la valeur d'une affectation. On peut ainsi faire des affectiation en cascade
- Les appels de fonctions
- Les structs
- les  appels de fonctions imbriquées
- la gestion des chaines de caractères est réalisée via une suite de caractères. Le code relatif aux strings est généré mais il n'a pas été testé car la machine TAM ne le supporte pas.

##Améliorations & limitations
**optimisation** Il aurait été possible de faire des optimisations sur le code généré. Actuellement il n'y a aucun pré-calcul. Ainsi l'affectation a = 3+4 charge 3 puis 4 sur la pile et enfin somme les 2 termes. Cela pourrait être optimisé avec l'ajout d'un attribut constExpr qui indique si la valeur d'un facteur est connue à la compilation. Dans le cas d'une opération entre 2 consExpr valide, la valeur serait calculée à la compilation.

##Tests
Il est possible de tester la correction du code généré en exécutant la commande `make test`.

Les fichiers de tests sont dans le dossier _utests_. Les fichiers .mcs sont compilés en .tam puis sont comparés aux fichiers .expected. Les fichiers -wrong.mcs sont des fichiers mcs avec une syntaxe incorrecte et dont le résultat attendu est une erreur.

#Micro CSharp
