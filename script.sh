#!/usr/bin/env bash

cd `dirname $0`

rm -rf generated
rm -rf results/*
mkdir generated results

Class='spoonRewriter.Main.'

if [ "$#" -ne 0 ]; then
    Processors[0]=$1
else
    Processors[0]='MinusToPlus'
    Processors[1]='Nothing'
    Processors[2]='AddToVariables'
fi

for p in "${Processors[@]}"
do
    # cp dossier island dans generated/nomProcessor (rm src/main/java)
    mkdir -p generated/$p/src/main/java
    cp -r island/src/test generated/$p/src
    cp -r island/maps generated/$p
    cp -r island/src/main/resources generated/$p/src/main/
    cp resources/pom.xml generated/$p
    # modifier pom
    sed -i "116s/.*/<processor>$Class$p<\/processor>/" island/pom.xml
    # mvn compile dans island
    mvn compile
    # mv les sources générées vers generated/nomProcessor/src/main/java
    mv island/target/generated-sources/spoon/fr generated/$p/src/main/java
    # générer un rapport de test
    cd generated/$p
    mvn surefire-report:report
    cp target/site/surefire-report.html ../../results/$p\_result.html
    cd ../..
done