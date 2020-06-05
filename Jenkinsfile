pipeline {
    agent any
    stages {
    	stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']],
    				userRemoteConfigs: [[url: 'https://github.com/kimgova/BPStoreAndForward.git']]])
				echo "Checkout ready."
            }
        }
        stage('Build') {
            steps {
                echo "Build ready."
            }
        }

    }
}