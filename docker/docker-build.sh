#!/bin/sh

# Setting versions
VERSION='1.0.1'

cd ..
./gradlew clean build -x test

ROOT_PATH=`pwd`
echo $ROOT_PATH

echo 'api docker image build'
cd $ROOT_PATH/api && docker build -t api:$VERSION .
echo 'api docker image build... Done'

echo 'nginx docker image build'
cd $ROOT_PATH/nginx && docker build -t nginx:$VERSION .
echo 'nginx docker image build... Done'
