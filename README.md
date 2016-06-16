# uCsharp
Compilateur pour un sous ensemble du Csharp

## Auteurs
- Antoine Beyet
- Matthieu Daumas
- Volodia Laniel
- Benoit Lemarchand


# uC
## Fonctionnalités
- Opérations sur les entiers.
- Structures conditionnelles et opérations booléennes.
- Définitions et appels de fonctions, mêmes imbriqués.
- Définitions et utilisations de structures.
- Affectations en cascades et récupération de la valeur d'une affectation.
- Définition et déréférencement de pointeurs.
- Rennomage de types.
- Typage fort et transtypage (cast) statique.
- Journal (log) des actions de la TDS lors de la compilation.

La gestion des chaines de caractères n'a pu être effectuée car la machine TAM ne le supporte pas. Cependant nous avons quand même une esquisse d'implémentation.

## Tests
Le compilateur est testé grâce à la commande `make test`. Celle-ci effectue deux chose:
- Elle vérifie que l'ensemble des fichiers _utests/*-wrong.mcs_ renvoient des erreurs de compilation
- Elle vérifie que l'ensemble des fichiers _utests/*.mcs_ compilent et engendrent le même code que les _utests/*.expected_
    Si une différence est constatée celle-ci est affichée.

**Nécessite python3**

## Améliorations possibles & limitations
**Optimisations possibles**
- **constexpr:** Notre compilateur effectue tous ses calculs à l'exécution (ex: dans `int a = 3 + 4;` `3 + 4` est calculé à l'exécution). Une optimisation possible aurait été de poser un booléen `constexpr` indiquant si la valeur d'un facteur est connu à la compilation. Ainsi, une opération entre deux `constexpr` peut être effectuer à la compilation.

- **assignation:** Lors d'une assignation une copie puis un dépilement inutiles sont effectués afin de permettre l'assignation en cascade. Celle-ci pourrait être supprimée lorsqu'elle n'est pas utilisée.

- **nop:** Notre code effectue parfois des `nop` (dépilement de 0, cast de I2B, ...). Celles-ci peuvent être supprimés.


# uCSharp
