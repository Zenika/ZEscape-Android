# ZEscape

Issu d'un sujet de stage à Lyon, ZEscape est un jeu mobile d’escape-game où vous vous trouvez
aspiré dans un système informatique d'où il vous faudra sortir.

En résolvant des puzzles intellectuels et en faisant appel à sa mémoire, le joueur est amené à
parcourir virtuellement différentes agences de Zenika pour collecter des éléments qui lui
permettront de s'évader.

L'expérience, pouvant durer jusqu'à 30 minutes, est prévue pour un seul joueur. Il utilisera
son smartphone comme passerelle entre le monde réel et le monde virtuel à travers des éléments
du décor comme des textes et des QR-Codes.

# Contribution

Pour contribuer, rendez-vous dans [CONTRIBUTING.md](CONTRIBUTING.md).

# Le coin tech

| Clé                      | Value                           |
|--------------------------|---------------------------------|
| Langages                 | Kotlin, Shell                   |
| Framework                | Android                         |
| Interface graphique      | Jetpack Compose + Navigation    |
| Tests unitaires          | JUnit5, MockK                   |
| Tests UI                 | Compose Test                    |
| Analyse statique de code | Android Lint, Detekt, Git Hooks |
| Base de données          | Room                            |
| Injection de dépendances | Hilt                            |
| Autres                   | CameraX                         |

## Architecture

Le projet est découpé en 3 grandes parties :

- `story` : le code spécifique aux différentes histoires
- `common` : les briques communes, partagées entre les différentes histoires
- `main` : le code de l'application, tout ce qui entoure les histoires (home, debug et crédits)

Dans chacune des histoires, le code est découpé en 3 tiers :

- `data` : l'accès et le stockage de données
- `domain` : les règles métiers
- `presentation` : l'affichage, la gestion des écrans et la navigation entre ces derniers

![Avec amour par Zenika](https://img.shields.io/badge/Avec%20%E2%9D%A4%EF%B8%8F%20par-Zenika-b51432.svg?link=https://oss.zenika.com)
