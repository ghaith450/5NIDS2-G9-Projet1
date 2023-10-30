pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...'
                git branch: 'main', url: 'https://github.com/ghaith450/5NIDS2-G9-Projet1.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
                // Nettoie le projet en utilisant Maven
                sh 'mvn clean'
            }
        }
        stage('MVN COMPILE') {
            steps {
                // Compile le projet en utilisant Maven
                sh 'mvn compile'
            }
        }
         stage('SonarQube Scan') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=squ_f7bad751dfe7fe4e94bcfcace13ce950318a3d19'
            }
        }
        stage('Deploy to Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'  // Déployer sur Nexus en sautant les tests
            }
        }


    }
}