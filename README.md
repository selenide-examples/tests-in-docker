# Run Chrome tests in different containers 

### How to run

* `./gradlew test-alpine`
* `./gradlew test-debian`

### Container size

One of the goals was to compare sizes of different docker containers.
On my machine, both images are similar in size (while Alpine image is a big smaller than Debian):

* `chrome-java-debian`: 1.67 GB
* `chrome-java-alpine`: 1.34 GB

## License

Distributed under the [MIT](http://choosealicense.com/licenses/mit/) license
