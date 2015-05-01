cd ..
mkdir WebContent\WEB-INF\classes\
javac -d "WebContent\WEB-INF\classes" -classpath "library\*;WebContent\WEB-INF\classes" src\BusinessLogic\*.java src\initialiseDatabase\*.java src\ProductExtractor\*.java
cd WebContent
jar cvf ..\Deployment\skimpy.war .
cd Deployment