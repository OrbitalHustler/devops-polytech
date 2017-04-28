#!/usr/bin/env bash

cd ../../backend
mvn -DskipTests clean package
cp ./target/tcf-backend.war ../docker/vup/.

cd ../docker/vup
sudo docker build -t vup .

rm -rf tcf-backend.war