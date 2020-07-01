rd /s /q out
mkdir out
javac -d out src\SnakeGame.java src\Apple.java src\Board.java src\GameEngine.java src\Point.java src\Snake.java
copy src\SnakeGameStylesheet.css out\SnakeGameStylesheet.css
cd out
java SnakeGame
pause
