pipeline {
    agent any

environment {
		DOCKERHUB_CREDENTIALS=credentials('docker')
	}

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...'
                git branch: 'main', url: 'https://github.com/raedgs/devops.git'
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
                 withSonarQubeEnv(installationName: 'aq'){
                sh 'mvn sonar:sonar -Dsonar.login=sqp_3e036e79b0f778327febec2b993cd6e39c370c9c'
            }
            }
        }
        stage('Deploy to Nexus') {
            steps {
               
                sh 'mvn deploy -DskipTests'  // Déployer sur Nexus en sautant les tests
            }
            
        }


        stage('Build Spring Application') {
            steps {
                sh "mvn clean package"  // Exemple pour construire avec Maven
                // Vous pouvez personnaliser cette étape pour votre processus de construction (ex. Gradle).
            }
        }
	    
	    
        
        stage('Build Docker ') {

			steps {
				sh 'docker build -t raed005/validation-devops:latest .'
			}
		}
	    stage('docker hub'){
            steps{
                script{
                    sh 'docker tag raed005/validation-devops:latest raed005/validation-devops:latest'
                    sh 'docker login -u raed005 -p 191JMT3825/r'
                    sh 'docker push raed005/validation-devops:latest'
                }
            }
        }
	    
	   stage('Junit') {
            steps {
                sh 'mvn -Dtest=Junit'
            }
        }
        
        
 stage("mockito"){
            steps {
                sh 'mvn -Dtest=mockito'
            }
        }

    }
}
