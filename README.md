## Overview
The Deployer Application is a Spring Boot-based application designed to manage the deployment of different types of applications using Docker. It provides a REST API to trigger deployment scripts for various application types.

## Technologies Used
- Java 17
- Spring Boot 3.4.0
- Maven
- Docker

## Prerequisites
- Java 17
- Maven
- Docker

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/yourusername/deployer.git
cd deployer
```

### Build the Project
```bash
mvn clean install
```

### Run the Application
```bash
mvn spring-boot:run
```

## REST API Endpoints

### Deploy Application
- **URL:** `/api/deployer/deploy`
- **Method:** `POST`
- **Request Parameter:**
  - `appType` (required): The type of application to deploy (e.g., `baccarat`, `sicbo`).
- **Response:**
  - `200 OK`: Deployment triggered successfully.
  - `400 Bad Request`: If `appType` is missing or empty.

#### Example Request
```bash
curl -X POST "http://localhost:8080/api/deployer/deploy" -d "appType=sicbo"
```


## Deployment Scripts
The deployment scripts are located in the `resources` folder:
- `baccarat_deploy_docker_player_Companion.sh`
- `sicbo_deploy_docker_player_Companion.sh`

These scripts handle the Docker image pulling, container stopping/removal, and starting a new container with the specified environment variables.

## Configuration
The application can be configured using the `application.properties` file located in the `src/main/resources` directory.


# Webhook Setup for Docker Hub Integration

## Purpose
This webhook triggers deployment processes based on specific repository updates on Docker Hub. The webhook endpoint includes parameters to identify the application type for deployment.

## Webhook Endpoint Template
```plaintext
http://<YourBaseURL>/api/deployer/deploy?appType=<RepositoryName>
```

## Steps to Configure Webhooks for Each Repository
1. **Log in to Docker Hub**  
   Go to the Docker Hub web interface and log in with your credentials.

2. **Navigate to the Repository**  
   Select the repository you want to integrate with the webhook.

3. **Access Webhooks Settings**  
   - Click on the "Webhooks" tab in the repository settings.
   - If no webhooks exist, click **Add Webhook**.

4. **Set Up the Webhook URL**  
   Use the template above and replace `<YourBaseURL>` with the base URL of your deployer service and `<RepositoryName>` with the appropriate application identifier.  

   Example for the `baccarat` repository:  
   ```plaintext
   http://<YourBaseURL>/api/deployer/deploy?appType=baccarat
   ```

5. **Save the Webhook**  
   Click **Save** to ensure the webhook is registered for the repository.

6. **Test the Webhook**  
   Trigger the webhook manually or by pushing a new Docker image to the repository. Monitor your deployment service to confirm successful deployment.

## Example Repository-Specific Webhooks
- For a `baccarat` application:  
  ```plaintext
  http://<YourBaseURL>/api/deployer/deploy?appType=baccarat
  ```
- For a `sicbo` application:  
  ```plaintext
  http://<YourBaseURL>/api/deployer/deploy?appType=sicbo
  ```


## Notes
- Ensure the deployer service endpoint (`/api/deployer/deploy`) is accessible and capable of handling requests from Docker Hub.
- Validate that the `appType` parameter matches your application's deployment configuration for accurate routing.
- Consider adding authentication to the webhook URL for added security.

By following this guide, you can systematically integrate deployment triggers for each Docker Hub repository.

## License
None 

## Author
- Mark Aguirre


Make sure to replace `https://github.com/yourusername/deployer.git` with the actual URL of your repository.
