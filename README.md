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
- Elle vérifie que l'ensemble des fichiers _utests/*-wrong.mcs_ renvoient des erreurs de compilation.
- Elle vérifie que l'ensemble des fichiers _utests/*.mcs_ compilent et engendrent le même code que les _utests/*.expected_. Si une différence est constatée celle-ci est affichée.

**Nécessite python3**

## Améliorations possibles & limitations
**Optimisations possibles**
- **constexpr :** Notre compilateur effectue tous ses calculs à l'exécution (ex: dans `int a = 3 + 4;` `3 + 4` est calculé à l'exécution). Une optimisation possible aurait été de poser un booléen `constexpr` indiquant si la valeur d'un facteur est connue à la compilation. Ainsi, une opération entre deux `constexpr` peut être effectuée à la compilation.

- **assignation :** Lors d'une assignation une copie puis un dépilement inutiles sont effectués afin de permettre l'assignation en cascade. Celle-ci pourrait être supprimée lorsqu'elle n'est pas utilisée.

- **nop :** Notre code effectue parfois des `nop` (dépilement de 0, cast de I2B, ...). Celles-ci peuvent être supprimés.


# uCSharp
## Fonctionnalités
- Définition de classe sans héritage.
- Définition d'attributs et de méthodes, publiques ou privés.
- Résolution publique uniquement depuis l'extérieur de la classe.
- Ajout d'un premier paramètre « this » aux méthodes.
- Définition d'un namespace, nested ou non. 
- Usage « using » de namespaces, un ou plusieurs.
- Résolution de noms dans les namespaces.
- Erreur lors d'une résolution ambigüe entre deux namespace.

## Tests
Ces fonctionnalités ont été testées de manière marginale et incomplète. La méthode de tests exhaustifs appliquée à la première partie est transposable pour l'écriture de tests de la seconde partie (et ça aurait très bien marché).

## Pistes et idées
Un bon nombre de fonctionnalités de la partie 2 n'ont pas été finalisées ou ajoutées pour la date du rendu, dont :
- **L'instanciation de classe :** Similaire à l'instanciation d'une « struct », mais sur le tas via un « MAlloc », et le code des méthodes n'est généré qu'une fois (le passage d'un paramètre « this » supplémentaire est fait aux méthodes). La génération de code associée à l'appel de méthodes, à la construction de classe, au pointeur « this ».
- **L'Héritage :** Une classe fille connaît la TDS de sa classe parente. Lors de l'ajout d'une méthode, on ne lève pas d'erreur en cas de duplicata (surcharge). La taille du type (et donc les offsets) de la classe fille est construite à partir de la taille de la classe parente (au lieu de partier de 0). 
- **Le pointeur « base » :** Le pointeur « base » est un pointeur « this » dont le type a été casté entre la classe courante (fille) vers sa classe parente.
- **La compatibilité de type et sous-type :** La comparaison dans la première version entre deux types est faite par une vérification d'égalité entre les deux instances de la classe « TYPE ». Une comparaison plus intelligente (éventuellement un « TYPE.equals) est à utiliser dans la partie deux, de manière à pouvoir tenter de caster « TYPE » en « CLASS » et de vérifier la compatibilité entre les deux.
- **Le mode de passage des paramètres :** Un attribut supplémentaire dans le TYPE caractérise le mode de passage, et une vérification est ajoutée à l'accès de ce type si la TDS courante est une TDS de fonction (on dispose d'un booléen dans la TDS pour ça). Une référence est un type héritant de « PTR », le déréférencement est implicite. 
- **Liaison tardive dynamique :** La liaison tardive dynamique, ou polymorphisme, ajoute un attribut caché pour chaque méthode susceptible d'être surchargée. Cet attribut est initialisé à l'instanciation d'une classe à la valeur du « vtag » de la méthode qui lui est associé. Ce « vtag » est un entier qui numérote de manière unique à partir de 0 les méthodes de chaque classe, une classe fille utilisant le compteur de sa classe parente (ainsi, sans multihéritage, toutes les classe du même arbre utilise le même compteur). Lors de l'appel d'une méthode, la valeur du « vtag » courant est ajoutée à l'adresse de début de la vtable, et l'adresse résultante est « CALLI ». L'instruction sur laquelle on atterit dans la vtable est un JMP sur le début de la méthode. Lors du polymorphisme, le vtag est propagé à la classe parente, ainsi les fonctions surchargées restent dotés du vtag de la classe fille.


