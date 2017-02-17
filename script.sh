#!/usr/bin/env bash

cd `dirname $0`

rm -rf generated
mkdir generated

Class='spoonRewriter.Main.'
Processors[0]='MinusToPlus'
Processors[1]='Nothing'

for p in "${Processors[@]}"
do
    # cp dossier island dans generated/nomProcessor (rm src/main/java)
    mkdir generated/$p
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
done