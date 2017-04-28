#!/usr/bin/env bash

sudo docker ps -a -q --filter=ancestor=dotnet | xargs -I {} sudo docker stop -t0 {}
sudo docker ps -a -q --filter=ancestor=dotnet | xargs -I {} sudo docker rm {}
sudo docker rmi dotnet
sudo docker build -f Dockerfile -t dotnet ../..
sudo docker run -ti dotnet
