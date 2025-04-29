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

         stage('Find Latest Report') {
            steps {
                script {
                    def reportFile = bat(script: """
                        for /f "delims=" %%i in ('dir /b /od ${REPORT_DIR}\\*.html') do set LAST_REPORT=%%i
                        echo %LAST_REPORT%
                    """, returnStdout: true).trim()
                    
                    if (reportFile) {
                        env.REPORT_FILE = reportFile
                        echo "Latest report file: ${env.REPORT_FILE}"
                    } else {
                        error "No report file found!"
                    }
                }
            }
        }

        stage('Publish Test Report') {
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
