pipeline {
    agent any
    
    
      tools {
        maven 'Maven 3.9.5'
        jdk 'myjdk'
    }

    environment {
        REPORT_DIR = 'src/test/resources/testreport/edaat'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Dhruva033/EdaatWeb.git', branch: 'master'
            }
        }

        stage('Install Dependencies') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test -DsuiteXmlFile=TestSuite/Client_P2.xml'
            }
        }

        stage('Find Dynamic Report Name') {
            steps {
                script {
                    def files = sh(script: "ls ${REPORT_DIR}/*.html", returnStdout: true).trim().split("\n")
                    if (files.length == 0) {
                        error "No report file found!"
                    }
                    env.REPORT_FILE = files[0].tokenize('/').last()
                    echo "Report file detected: ${env.REPORT_FILE}"
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
