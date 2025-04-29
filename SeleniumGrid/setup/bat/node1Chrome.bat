set mypath=%cd%
cd ../node1

java -Dselenium.LOGGER=selenium.log -Dwebdriver.chrome.driver=../../chromedriver.exe -jar selenium-server-standalone-3.12.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5551 -browser browserName=chrome

cd %mypath%