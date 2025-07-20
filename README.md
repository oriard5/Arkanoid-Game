# 🎮 Arkanoid Game – Java OOP Project

This is a Java-based **Arkanoid (Breakout)** game developed using **Object-Oriented Programming** principles as part of Bar-Ilan University's Java programming course (Assignments 2–6). The game uses the `biuoop` library for graphics and input handling.

---

## 📦 Features

-  Block, Ball, and Paddle objects with collision detection
-  Keyboard-controlled paddle
-  Score and lives tracking
-  Multiple levels with custom block layouts
-  Observer (listener) pattern for block removal and scoring
-  Win screen and Game Over screen
-  Animation loop using biuoop

---

## 🧰 Requirements

- Java **11 or later**
- `biuoop-1.4.jar` (included in the assignment package)

---

## 📦 Setup
Download the project folder from the ass6 directory.

---

## 📁 Project Structure

ass6/  
├── src/              # Java source files  
├── bin/              # Output directory for compiled .class files  
└── biuoop-1.4.jar    # External GUI/input library  



---
## ⚙️ How to Compile

```
javac -d bin -cp "biuoop-1.4.jar" -sourcepath src src\*.java

```
---


## ▶️ How to Run
You can run the game by specifying the level numbers you want to play — in any order and any amount of times.
The available levels are:

1 – Direct Hit

2 – Wide Easy

3 – Green 3

4 – Final Four

```
java -cp "bin;biuoop-1.4.jar" Game 1 2 3 4
```

💡 You can repeat levels or choose any order. For example:

```
java -cp "..." Game 1 1 4 2
```
---

## 🎮 How to Play
You start with 5 lives.

- Use the arrow keys to move the paddle left and right.

- Press P to pause the game. Press Space to resume.

- The goal is to break all the blocks on the screen.

- When you destroy a random box, one of the following can happen:

   - Nothing
    
   - The ball disappears (gets removed)
    
   - The ball multiplies into several balls

🏆 Finish all selected levels without losing all your lives to win!

---






