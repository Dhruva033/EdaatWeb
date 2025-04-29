set mypath=%cd%
cd ../../..

mvn clean test -Dtesttype="smoke" -DsuiteXmlFile=CoreIFSTestSuiteSeq.xml

cd %mypath%