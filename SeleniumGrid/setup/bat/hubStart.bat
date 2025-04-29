set mypath=%cd%
cd ../hub

java -jar -Dselenium.LOGGER=selenium.log selenium-server-standalone-3.12.0.jar -role hub

cd %mypath%