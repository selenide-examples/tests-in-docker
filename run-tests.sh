#!/bin/sh
set -e

dir=$0
OS=$1
CONTAINER="chrome-java-$OS-tests"

echo "Run tests in $OS ..."
docker stop $CONTAINER || echo "No previous container to cleanup"
docker build -f "Dockerfile.$OS" --progress plain -t "chrome-java-$OS" .
docker run -d --rm --name $CONTAINER "chrome-java-$OS"

docker exec $CONTAINER ./gradlew test -Pheadless=true --info --no-daemon || echo "TESTS FAILED"

docker cp $CONTAINER:/app/build/reports ./build/
docker stop $CONTAINER