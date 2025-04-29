set mypath=%cd%
cd ../node2

java -Dselenium.LOGGER=selenium.log -Dwebdriver.gecko.driver=../../geckodriver.exe -jar selenium-server-standalone-3.12.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5552 -browser browserName=firefox

cd %mypath%