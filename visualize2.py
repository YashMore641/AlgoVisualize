import subprocess
import matplotlib.pyplot as plt

# Run C++ program and capture output
result = subprocess.run(["sorting_program.exe"], capture_output=True, text=True)

# Split into steps
steps = result.stdout.strip().split("\n")

# Plot steps
for i, step in enumerate(steps):
    arr = list(map(int, step.split()))
    plt.bar(range(len(arr)), arr)
    plt.title(f"Step {i+1}")
    plt.pause(0.5)
    plt.clf()

plt.show()
