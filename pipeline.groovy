pipeline {
    agent {
        node { label 'slave'}
    }

    stages {
        // stage('checkout') {
        //     steps {
        //         sh """
        //         pwd
        //         git clone https://github.com/pes-lab/bookinfo-helm.git
        //         pwd
        //         """
        //     }
        // }
        stage('run pipeline script') {
            steps {
                sh """
                    pwd
                    ls
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
