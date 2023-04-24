#!/bin/bash

mvn test -Denv=$1 -Dcucumber.filter.tags=$2
