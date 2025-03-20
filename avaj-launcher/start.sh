find * -name "*.java" > sources.txt
javac @sources.txt
java -cp src Main scenario.txt
