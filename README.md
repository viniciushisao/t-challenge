# Conference Track Management

## About this file

This file has formatting text called GitHub Flavored Markdown.
You can read it without any tool but for better visualization you can use some viewer for Markdown. 

I personally never used a Markdown viewer, but I found some interesting [here](http://mashable.com/2013/06/24/markdown-tools/#W7HNkkc1AZqV)


## About this project

This project is a test project I developed based on **Problem Two: Conference Track Management**

## Tools I used to make this project

1. [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. [IntelliJ IDEA](https://www.jetbrains.com/idea/)
1. [JUnit4](http://junit.org/junit4/)

## How to run

1. Before run just be sure you have Java 8 installed
    1. On terminal, execute ```java -version```
    1. I didn`t make tests but I am almost sure it will execute on Java 7 too.
1. I am running all commands in MacOs. If you are using another OS commands may differ a little.

### Via Command line

1. Open command line tool
1. Go to ```/src``` folder
1. Execute ```javac -sourcepath . -d ./build/ *.java```
    1. This will compile all java classes and move then to ```./build``` folder
1. Go to ```/build``` folder
1. Execute ```java Main ../../test/res/talks_test_1.txt```
    1. This will execute the main class with file ```talks_test_1.txt```
    1. The file above has the data provided for this.
1. At the end of the output you will see a final report, where you can check if entrance worked or not.

### Via IntelliJ

1. Download and install IntelliJ
1. Open IntelliJ and open the base folder of the project.

## Running the tests

This project has a lot of tests :D

## Things to think better

1. I am using a sort of KnapSack problem solving algorithm. Is Bin Packing better?
1. All the times I am generating the KnapSack matrix.

## More References

1. [GitHub Flavored Markdown](https://help.github.com/categories/writing-on-github/)
1. [KnapSack Problem](https://en.wikipedia.org/wiki/Knapsack_problem)
1. [Bin packing problem](https://en.wikipedia.org/wiki/Bin_packing_problem)
