# AlgoVisualize

A sorting algorithm visualizer built with **Java (Spring Boot)**. Enter your own array values in the browser, pick an algorithm, and watch the sorting happen step by step.

## Tech Stack

- **Backend:** Java 17+ with Spring Boot 3.5 (Maven)
- **Frontend:** HTML, CSS, JavaScript (Thymeleaf template)
- **Legacy:** C++ sorting implementations and Python matplotlib scripts (`visualize.py`, `visualize2.py`) kept from the original project

## Algorithms

- Bubble Sort
- Selection Sort
- Insertion Sort

## How to Run

```bash
mvn spring-boot:run
```

Then open [http://localhost:5000](http://localhost:5000).

1. Enter comma-separated values, e.g. `34, 21, 51, 83, 9` (leave blank for the demo array)
2. Click a sort button
3. Watch the step-by-step visualization

## API

`POST /sort` with a JSON body:

```json
{ "algo": "bubble", "array": [34, 21, 51, 83, 9] }
```

Returns the array state after each pass as JSON — e.g. `[[21,34,51,9,83], ...]`. The `array` field is optional; the server uses a demo array when omitted.
