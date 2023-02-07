# API pour le projet SWISSCANSAT 2023

## Installation de Maven et connection à GitHub
Pour cette partie il suffit de suivre la documentation créée par Virtuozzo (Le système utilisé par Jelastic)

[Déployer son application Java avec Git](https://www.virtuozzo.com/company/blog/git-push-deploy-to-containers/)

### Changer le JDK utilisé par Spring
1. Au niveau de l'environnement, dans topologie de l'environnement
2. Remplacer l'actuel JDK par in minimum 17

### Ajouter les variables d'environnement
1. Au niveau de Spring Boot cliquer sur les paramètres puis Variables
2. Ajouter les variables d'environnement suivantes :

- DB_URL
- DB_USERNAME
- DB_PASSWORD
- API_USER
- API_PASSWORD
- CORS_ALLOWED_ORIGINS

### Déployer l'application depuis Maven
Se rendre au niveau du projet dans Maven, cocher déployer et choisir Spring Boot comme environnement

![image](https://user-images.githubusercontent.com/94681693/217271545-09035ccd-f2bf-4fa8-a0b0-8b40fd71d843.png)
