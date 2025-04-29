set mypath=%cd%
cd ../node3

java -Dwebdriver.ie.driver=../../IEDriverServer.exe -jar selenium-server-standalone-3.12.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5553 -browser "browserName=internet explorer,version=11"

cd %mypath%