# Symbiote-2D-Platformer-Game

> 🎮 Gameplay demo video 


https://github.com/user-attachments/assets/60ac2437-39c4-48ff-b156-3731527ea377


Symbiote is a space‑themed 2D platformer inspired by the Marvel symbiotes, built as an Object Oriented Programming project in Java.

## Story & Gameplay

- Humans invade the symbiote home planet **Kylntar** to exploit its resources.
- You play as **Aureus**, the last hope of the symbiote race, fighting back against the human invasion. 
- Run, jump, navigate platforms and attack enemies using keyboard and mouse controls. 

## Tech Stack & Concepts

- **Language & UI:** Java, Swing (`JFrame`, `JPanel`) for windowing and rendering.
- **Paradigm:** Strong focus on OOP principles – encapsulation, abstraction, inheritance and polymorphism across all core classes. 
- **Architecture:** Separate packages for `main`, `entities`, `levels`, `inputs` and `utilz` for clean modular design. 

## Main Features

- Custom **game loop** handling FPS/UPS and rendering via `Game` and `GamePanel`. 
- **Player system:** `Player` extends `Entity` with animations, movement, collision and attack logic.
- **Level system:** `Level` and `LevelManager` load tile data from images and render a full platformer level.
- **Input handling:** `KeyboardInputs` for WASD movement and `MouseInputs` for click‑to‑attack.
- **Utilities:** `LoadSave`, `HelpMethodClass`, and `Constant` for sprite loading, collision helpers and shared constants.

## Controls

- **W / A / S / D** – Move Aureus (jump, left, down, right).  
- **Left mouse click** – Trigger attack.   

## How to Run

1. Open the project in your IDE or navigate to the `src` folder. 
2. Compile and run the `Mainclass` (the entry point that creates a `Game` instance and starts the loop). 

## Future Scope
- Implement advanced enemy AI, additional levels, and refined collision handling to enhance gameplay complexity.
- Aureus as an evolved character with upgradeable abilities, richer animation states, and configurable stats for progression​
<img width="236" height="428" alt="Aureus_main_p1" src="https://github.com/user-attachments/assets/cdb9c5c3-6998-4a35-afaf-0363cb207b29" />

