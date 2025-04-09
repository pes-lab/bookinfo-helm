pipeline {
    agent {
        node { label 'slave'}
    }
    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'stg', 'prod'], description: '选择运行环境')
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
