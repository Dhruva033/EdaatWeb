set mypath=%cd%
cd ../../..

mvn clean test -DsuiteXmlFile=SampleTest.xml

cd %mypath%