pipeline {
    agent {
        node { label 'slave_uat'}
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
