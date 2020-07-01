# SnakeGame

## Info

**Snake Game** - a computer game in which the player uses the arrow keys to control snake. The snake moves in a closed rectangle and cannot "hit" itself.
The player's task is to get as many points as possible by feeding the snake
food (apples) appearing on the screen.


The application was created in **Java version 8 (8u241)** with additionall **JavaFx** library.

<p align="center">
  <img src="/gifs/capture.gif" width=400/>
</p>

## Classes

* **SnakeGame** - The main application class responsible for creating the application window and
user interaction handling.
* **Apple** - A class responsible for handling apples.
* **Board** - The class responsible for handling the game board.
* **GameEngine** - The class responsible for refreshing the game interface.
* **Point** - Class responsible for handling points visualized in the interface.
* **Snake** - The class responsible for handling the snake.

## Run


The application can be started using the **BAT batch** file that allows you to compile and run the entire project. To do this, run the file
*SnakeGame_CompileAndRun.bat*, located in the main project directory.

## Game and control

The Snake is controlled by using the arrows on the keyboard which respectively
decide on the direction of movement. To start the game, press the **"START"** button.

<p align="center">
  <img src="/images/start.png" width=400/>
</p>

<p align="center">
  <img src="/images/game.png" width=400/>
</p>


## Creating a JAR file

A batch file has also been added to the project to create **JAR file**. The JAR file is a set of files with compiled classes. To create an archive, run the file
*SnakeGame_CreateJar.bat*. JAR file **(SnakeGame.jar)** should appear.

## Docs

The project also includes class documentation that allows you to view methods
used in each class. The documentation was created using the tool
**JavaDoc** which enables automatically generating documentation based on
included in the source code tags in the comments. Documentation is locatedn in the **docs** folder the **index.html** file.


