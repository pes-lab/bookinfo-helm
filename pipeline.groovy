pipeline {
    agent {
        node { label 'slave'}
    }

    stages {
        stage('run pipeline script') {
            steps {
                sh """
                    pwd
                    ./upgrade.sh
                """
            }
        }
    }
    
    post {
        success {
            echo "success"
        }
        failure {
            echo "failure"
        }
    }
}
