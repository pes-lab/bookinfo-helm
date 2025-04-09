pipeline {

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'uat', 'stg'], description: '选择运行环境')
    }  
    agent {
        node { 
            label {
                switch(parameters.ENVIRONMENT) {
                    case 'dev':
                        return 'slave_dev'
                    case 'uat':
                        return 'slave_uat'
                    case 'stg':
                        return 'slave_stg'
                    default: 
                        return 'slave'
                }
            }
        }  
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
