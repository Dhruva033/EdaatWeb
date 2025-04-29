set mypath=%cd%
cd ../../..

mvn clean test -Dtesttype="smoke" -DsuiteXmlFile=SampleTest.xml

cd %mypath%