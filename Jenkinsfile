pipeline {
    agent any

    environment {
        REPORT_DIR = 'src/test/resources/testreport/edaat'
        REPORT_FILE = 'Admin_SystemManagement_MyBills_Client_Payables_P1_P2_P3_P4_SecondRun_*.html'
    }

    stages {
        stage('Checkout') {
            steps {

                git url: 'https://github.com/Dhruva033/EdaatWeb.git', branch: 'master'
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh 'mvn test -DsuiteXmlFile=testsuite/Client_P2.xml'
                }
            }
        }

        stage('Publish Test Reports') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: "${REPORT_DIR}",
                    reportFiles: "${REPORT_FILE}",
                    reportName: 'Automation Test Results'
                ])
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed!'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
