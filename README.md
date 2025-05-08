# Avaj Launcher

Avaj Launcher is a Java-based aircraft simulation project built as part of the 42 school post-curriculum. 
It simulates the movement of aircraft (Balloon, Helicopter, JetPlane) based on changing weather conditions.

## 🚀 Getting Started

### Requirements
- Java 8+ should be sufficient

### Compile
find . -name "*.java" > sources.txt  
javac @sources.txt

### Run
cd main/
java main scenario/scenario.txt

## 📄 Scenario Format

simulation_count  
type name longitude latitude height  
...

**Example:**

5  
Baloon B1 2 3 20  
JetPlane J1 23 44 32  
Helicopter H1 654 33 20  

## 📝 Output

Simulation results are written to `simulation.txt`.
