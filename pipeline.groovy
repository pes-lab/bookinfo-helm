pipeline {
    agent {
        node { label 'slave'}
    }

    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/pes-lab/bookinfo-helm.git'
            }
        }
        stage('run pipeline script') {
            steps {
                sh """
                    pwd
                    upgrade.sh
                """
                // sh """
                //   helm ls
                // """
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
