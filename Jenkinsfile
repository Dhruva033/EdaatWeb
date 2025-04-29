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
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test -DsuiteXmlFile=TestSuite/Client_P2.xml'
            }
        }

        stage('Find Dynamic Report Name') {
            steps {
                script {
                    def reportPath = new File(env.REPORT_DIR)
                    if (!reportPath.exists()) {
                        error "Report directory does not exist: ${env.REPORT_DIR}"
                    }

                    def htmlFiles = reportPath.listFiles().findAll { it.name.endsWith('.html') }
                    if (htmlFiles.isEmpty()) {
                        error "No HTML report found in ${env.REPORT_DIR}"
                    }

                    // Pick the most recently modified HTML report
                    def latestFile = htmlFiles.max { it.lastModified() }
                    echo "Found latest report file: ${latestFile.name}"
                    env.REPORT_FILE = latestFile.name
                }
            }
        }

        stage('Publish Test Reports') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: "${env.REPORT_DIR}",
                    reportFiles: "${env.REPORT_FILE}",
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
