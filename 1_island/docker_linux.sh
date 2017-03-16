#!/usr/bin/env bash

cd `dirname $0`

#rm -rf results
#mkdir results

sudo docker build -t devops -f Dockerfile  .
sudo docker rm devops
sudo docker run -v ~/.m2:/root/.m2 -v `pwd`/results/:/usr/local/devops/results --name devops --net=host devops

