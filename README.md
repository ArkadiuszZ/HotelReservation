# Hotel Reservation

Simple appliaction written in java for managing hotel rooms occupancy across time.

## Getting Started

### Prerequisites

#### Java JDK

You can use [Oracle](https://www.oracle.com/technetwork/java/javase/downloads/index.html) or [OpenJDK](https://openjdk.java.net/install/index.html) to build this application from source.

#### JavaFX

You can download [javaFX](https://gluonhq.com/products/javafx/) or you can build it [from source](https://github.com/openjdk/jfx).

#### PostgreSQL Database

You can download installer from [this site.](https://www.postgresql.org/download/)

#### IDE (optional)

You can use your favourite IDE wich supports building java to actually build this application.

## Compiling
```sh
#assumming your current directory is HotelReservation 
#this will create bunch of class files in HotelReservation directory
javac --module-path <"path to your javafx lib dir"> --add-modules javafx.controls -d ./ src/*.java

```
## Running
```sh
java  -p ./resources/:<"path to your javafx lib dir"> --add-modules javafx.controls Main
```
## TODO

- [ ] Make initial release.
- [ ] 100% unit test coverage.
- [ ] Documentation.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
