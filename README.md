
# Système de Gestion de Bibliothèque
Ce projet consiste à développer une application console en Java 8 pour automatiser la gestion des livres et magazines dans une bibliothèque municipale. L'application permet de gérer l'inventaire des documents, ainsi que les emprunts et retours.

## Structure de l'Application
L'application est structurée en plusieurs couches pour assurer une séparation claire des responsabilités :

### Couche de Présentation
-  **Classe ConsoleUI** : Interface utilisateur en mode console permettant d'interagir avec l'application.
### Couche Métier
- **Classe Abstraite Document**: Classe de base pour les documents avec les attributs et méthodes communs.
- Attributs : id, titre, auteur, datePublication, nombreDePages
- Méthodes abstraites : emprunter(), retourner(), afficherDetails()
- Classe Livre : Hérite de Document et représente un livre.
- Attribut supplémentaire : isbn
- Implémentation des méthodes abstraites
- Classe Magazine : Hérite de Document et représente un magazine.
- Attribut supplémentaire : numero
- Implémentation des méthodes abstraites
- Classe Bibliotheque : Gère l'inventaire des documents.
### Couche Utilitaire
- **Classe DateUtils** : Fournit des utilitaires pour la manipulation des dates.
## Fonctionnalités Principales
- Ajouter un document (livre ou magazine)
- Emprunter un document
- Retourner un document
- Afficher tous les documents
- Rechercher un document
## Spécifications Techniques
- Utilisation de ArrayList pour stocker les documents.
- Implémentation d'une recherche rapide avec HashMap<String, Document>.
- Intégration de la Java Time API pour la gestion des dates.
- Application des expressions lambda pour simplifier le code.
## Interface Utilisateur
L'application offre un menu interactif dans la console avec les options suivantes :

1. Ajouter un document
2. Emprunter un document
3. Retourner un document
4. Afficher tous les documents
5. Rechercher un document
6. Quitter 

Veuillez entrer votre choix (1-6) :

## Contraintes
- Les données persistent en mémoire jusqu'à la fermeture de l'application.
- Validation des entrées utilisateur pour gérer les erreurs potentielles.
## Gestion de Projet
- Git : Utilisé pour le contrôle de version.
- JIRA : Gère les tâches et les sprints.
- Participation à des daily stand-ups simulés pour le suivi du projet.

# Conception UML 
## Diagramme de cas d'utilisation :
<img width="587" alt="BiblioUseCase" src="https://github.com/user-attachments/assets/9be929c0-670f-4f84-868b-cd58acf2e396">

## Diagramme de classe : 

<img width="458" alt="BiblioClass" src="https://github.com/user-attachments/assets/5f444ba3-e352-44fa-9073-ef6255dc43a4">

## Planification JIRA :

#### https://omama.atlassian.net/jira/software/projects/GDB/boards/4/timeline?shared=&atlOrigin=eyJpIjoiMTYyY2RiMGVlMjM0NGRiNWE3MjY3NzZhMTY0YWVhNzciLCJwIjoiaiJ9