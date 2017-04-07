#!/usr/bin/env bash

cd ../../2_cookie_factory_splitted/dotNet
./compile.sh
cd -
mv ../../../../2_cookie_factory_splitted/dotNet/bank.exe .
docker 