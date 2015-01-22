Product-Extractor
=================

To compile and run this program, you will need the [Jsoup](http://jsoup.org/) jar package.

## Web Spider
This program is responsible for collecting links to products.

### Compilation
```
javac -cp jsoup-*.jar Department.java Product.java
javac -cp .:jsoup-*.jar DepartmentSpider.java
javac -cp .:jsoup-*.jar TescoGroceries.java
```

### Running the Spider
This program is fully automated. To run it, simply type

```
java -cp .:jsoup-*.jar TescoGroceries
```
---

## Web Scraper
This program is responsible for collecting information about products on a web page.

### Compilation
```
javac -cp .:jsoup-*.jar ProductExtractor.java
```

### Running the Scraper
This program requires a URL of a department web page (the one with items listed in a grid).
The results are written to a file.
```
java -cp .:jsoup-*.jar ProductExtractor <textfile with results> <department URL>
```