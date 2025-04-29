set mypath=%cd%
cd ../node4

java -Dwebdriver.edge.driver=../../SeleniumGrid/MicrosoftWebDriver.exe -jar selenium-server-standalone-3.12.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5554 -browser "browserName=MicrosoftEdge"

cd %mypath%