#!/bin/bash

# set vars
VERSION=0.0.8
TAG=latest
DOCKER_IMAGE_NAME=altonomy/qa-bdd
ALT_REPO_ECR=688552931334.dkr.ecr.ap-southeast-1.amazonaws.com

# tag images
docker tag $DOCKER_IMAGE_NAME "$ALT_REPO_ECR/$DOCKER_IMAGE_NAME:$VERSION"
docker tag $DOCKER_IMAGE_NAME "$ALT_REPO_ECR/$DOCKER_IMAGE_NAME:$TAG"

# upload image
aws ecr get-login-password --region ap-southeast-1 | docker login --username AWS --password-stdin $ALT_REPO_ECR
docker push "$ALT_REPO_ECR/$DOCKER_IMAGE_NAME:$VERSION"
docker push "$ALT_REPO_ECR/$DOCKER_IMAGE_NAME:$TAG"
