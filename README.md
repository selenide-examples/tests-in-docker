# Run Chrome tests in different containers 

This project shows an easy way to run web tests where browser is running _locally_ (without TestContainers, Selenoid, Moon and other clouds).
The browser is running on the same machine where tests are running. 
It's the easiest and fastest way to run web tests.

### How to run

* `./gradlew test`  - just runs tests locally
* `./gradlew test-alpine` - runs both tests and browser inside a container (Alpine-based)
* `./gradlew test-debian` - runs both tests and browser inside a container (Debian-based)
* `./gradlew selenium-chrome` - runs both tests and browser inside a container (base image: Selenium Chrome)

NB! All of these commands generate test report in `build/reports` folder (as it's common in Gradle projects).

### Container size

One of the goals was to compare sizes of different docker containers.
On my machine, both images are similar in size (while Alpine image is a big smaller than Debian):

* `chrome-java-debian`: 1.67 GB
* `chrome-java-alpine`: 1.34 GB
* `chrome-java-selenium-chrome`: 2.69 GB

## License

Distributed under the [MIT](http://choosealicense.com/licenses/mit/) license
