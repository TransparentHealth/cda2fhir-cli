CDA2FHIR-Command Line Interface
===============================


This tool creates a command line wrapper around the  cda2fhir package from https://github.com/amida-tech/cda2fhir.


This is a work in progress.


Here are the setup steps:

1. Install a Java compiler and maven. Hoe to do this can be found elsewhere online.

2. Download and install dependencies from the cda2fhir project


    git clone https://github.com/amida-tech/cda2fhir.git
    cd cda2fhir
    mvn clean install -DskipTests

3. Setup a classpath for the newly installed resources.


   export CLASSPATH=$HOME/.m2/repository/tr/com/srdc/cda2fhir/0.0.13-SNAPSHOT/cda2fhir-0.0.13-SNAPSHOT.jar:.

4. Compile

   
   javac cda2fhircli.java

5. Run


   java CommandLine testcda.xml


