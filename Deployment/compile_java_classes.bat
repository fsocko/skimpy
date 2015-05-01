cd ..
mkdir binary
javac -d "binary" -classpath "library\*" src\BusinessLogic\*.java src\initialiseDatabase\*.java src\ProductExtractor\*.java
cd Deployment