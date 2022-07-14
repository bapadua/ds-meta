#!/bin/bash
echo "building ds meta"
cd ./backend
chmod +x ./gradlew
./gradlew clean build -x test