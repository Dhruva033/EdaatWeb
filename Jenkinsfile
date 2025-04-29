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
                bat '''
                for /f "delims=" %%i in ('dir /b /od %REPORT_DIR%\\*.html') do set "latest=%%i"
                echo Latest Report=!latest! > latest_report.txt
                '''
            }
        }

        stage('Publish HTML Report') {
            steps {
                script {
                    def reportFile = readFile('latest_report.txt').trim().replace('Latest Report=', '')
                    echo "Latest report file: ${reportFile}"

                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: "${env.REPORT_DIR}",
                        reportFiles: reportFile,
                        reportName: 'Automation Test Results'
                    ])
                }
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
