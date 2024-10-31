# Spring Boot Thymeleaf Application with MySQL on Kubernetes

This is a Spring Boot application using Thymeleaf for the front-end and MySQL for the database. The application is packaged as a Helm chart and deployed on a local Kubernetes cluster.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Deployment](#deployment)
- [Troubleshooting](#troubleshooting)

## Features

- User-friendly interface using Thymeleaf
- CRUD operations with MySQL database
- Deployed on a local Kubernetes cluster
- Helm chart for easy deployment and management

## Technologies Used

- **Spring Boot**: Framework for building Java applications
- **Thymeleaf**: Template engine for rendering web pages
- **MySQL**: Relational database management system
- **Kubernetes**: Container orchestration platform
- **Helm**: Package manager for Kubernetes

## Prerequisites

Make sure you have the following installed on your local machine:

- Java 21 or later
- Maven
- Docker
- Kubernetes (with a local setup, e.g., Rancher Desktop)
- Helm

## Installation

1. Clone the repository: ``` git clone https://github.com/dibyendu83/springboot-helm-kubernetes.git```
2. Build the Spring Boot application: ``` mvn clean package ```
3. Ensure your local Kubernetes cluster is running.

## Configuration

Before deploying the application, you may need to configure the following parameters in the
``` values.yaml ``` file of your Helm chart:
- **Database settings**: Update the MySQL configuration with your database name, user, and password.
- **Service settings**: MySQL service is a headless service and spring boot app is Cluster IP.
- **Ingress settings**: Update the ingress configuration like host name etc. (default is spring-demo.com), add this host entry in your host file.

## Usage

1. Before deploying the application using helm need to install **NGINX** Ingress controller using helm
   - Add the NGINX Helm repository: ``` helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx ```.
   - Update the helm repo : ``` helm repo update ```.
   - Install the NGINX Ingress Controller: ``` helm install nginx-ingress ingress-nginx/ingress-nginx --namespace ingress --create-namespace ```
   - Verify the installation: ``` kubectl get all -n ingress ```.
2. Deploy the application using Helm: ``` helm install springboot-app helm-chart```.
3. Verify the release using ``` helm list ```.
4. Access the application: ``` http://spring-demo.com```

## Deployment

To update your application, make changes to the code, rebuild the Docker image, and update the Helm chart as needed:

1. Rebuild your application: ``` mvn clean package ```
2. Build the docker image and upload into the docker hub.
3. Upgrade the Helm release: ``` helm upgrade springboot-app helm-chart ```

## Troubleshooting

- If you encounter issues with the application not starting, check the logs of the Spring Boot application: ``` kubectl logs <pod-name> ```
- Ensure the MySQL database is up and running. You can check its status with: ``` kubectl get pods ```
- If you encounter any issue from ingress side check the log from ingress side. ``` kubectl logs <ingress-pod-name> -n ingress --tail=100 -f ```
- For more detailed troubleshooting, refer to the Kubernetes documentation or Spring Boot logs.