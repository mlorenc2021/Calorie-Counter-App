# Burger Calorie Counter

![Image](https://github.com/user-attachments/assets/a19549fd-a1ee-4fd3-949f-ea02109ac548)
![Image](https://github.com/user-attachments/assets/19477ffa-a4c4-4fec-851e-77f704a83775)

An interactive Android app that allows users to customize a burger and view its total calorie count based on selected ingredients. Built for educational purposes using Java and Android SDK.

## Features

- Choose patty type: beef, turkey, or veggie
- Optional cheese: cheddar or mozzarella
- Toggle bacon on or off
- Adjust sauce amount using a SeekBar
- Live calorie total updates as selections change

## Technologies Used

- Java
- Android SDK
- AndroidX
- Android UI Widgets: RadioGroup, CheckBox, SeekBar, TextView

## How It Works

The app creates a `Burger` object with calorie values for each selected option. It listens for user interaction and updates the calorie count dynamically whenever any burger component changes.

### Burger Options and Calories

| Component     | Options         | Calories |
|---------------|------------------|----------|
| Patty         | Beef, Turkey, Veggie | 90, 170, 150 |
| Cheese        | None, Cheddar, Mozzarella | 0, 113, 78 |
| Bacon         | Off / On         | 0 / 86   |
| Sauce         | 0 - 100 (SeekBar) | Custom   |

## Class Structure

### MainActivity.java

- Handles UI interaction and logic for updating calories.
- Listens to:
  - RadioGroup for patty and cheese
  - CheckBox for bacon
  - SeekBar for sauce

### Burger.java

- Contains constants and fields for each burger ingredient's calories
- Provides setters and a method to calculate the total

## How to Run

1. Clone or download the project.
2. Open in **Android Studio**.
3. Run on an emulator or connected device.



