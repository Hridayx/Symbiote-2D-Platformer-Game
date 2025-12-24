# Symbiote-2D-Platformer-Game

# Symbiote – 2D Platformer Game

> 🎮 Gameplay demo video will be added here soon.

Symbiote is a space‑themed 2D platformer inspired by the Marvel symbiotes, built as an Object Oriented Programming project in Java. [file:62]

## Story & Gameplay

- Humans invade the symbiote home planet **Kylntar** to exploit its resources. [file:62]  
- You play as **Aureus**, the last hope of the symbiote race, fighting back against the human invasion. [file:62]  
- Run, jump, navigate platforms and attack enemies using keyboard and mouse controls. [file:62]

## Tech Stack & Concepts

- **Language & UI:** Java, Swing (`JFrame`, `JPanel`) for windowing and rendering. [file:62]  
- **Paradigm:** Strong focus on OOP principles – encapsulation, abstraction, inheritance and polymorphism across all core classes. [file:62]  
- **Architecture:** Separate packages for `main`, `entities`, `levels`, `inputs` and `utilz` for clean modular design. [file:62]

## Main Features

- Custom **game loop** handling FPS/UPS and rendering via `Game` and `GamePanel`. [file:62]  
- **Player system:** `Player` extends `Entity` with animations, movement, collision and attack logic. [file:62]  
- **Level system:** `Level` and `LevelManager` load tile data from images and render a full platformer level. [file:62]  
- **Input handling:** `KeyboardInputs` for WASD movement and `MouseInputs` for click‑to‑attack. [file:62]  
- **Utilities:** `LoadSave`, `HelpMethodClass`, and `Constant` for sprite loading, collision helpers and shared constants.

## Controls

- **W / A / S / D** – Move Aureus (jump, left, down, right).  
- **Left mouse click** – Trigger attack.   

## How to Run

1. Open the project in your IDE or navigate to the `src` folder. [file:62]  
2. Compile and run the `Mainclass` (the entry point that creates a `Game` instance and starts the loop). [file:62]
