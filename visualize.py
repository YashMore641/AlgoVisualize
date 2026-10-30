import subprocess, shlex
import matplotlib.pyplot as plt

# Function to run exe and capture steps
def run_and_parse(cmd):
    proc = subprocess.Popen(cmd, stdout=subprocess.PIPE, text=True)
    output, _ = proc.communicate()
    
    steps = []
    for line in output.splitlines():
        if line and not line.endswith(":"):  # skip "Bubble Sort Steps:" etc.
            try:
                arr = list(map(int, line.strip().split()))
                steps.append(arr)
            except:
                pass
    return steps

# Run all algorithms
steps_bubble    = run_and_parse(["bubble_steps.exe"])
steps_selection = run_and_parse(["selection_steps.exe"])
steps_insertion = run_and_parse(["insertion_steps.exe"])

# --- Visualization ---
SPEED = 1.0 # adjust speed (seconds per step)

def plot_steps(steps, title, speed=SPEED):
    plt.figure()
    for i, arr in enumerate(steps):
        plt.bar(range(len(arr)), arr)
        plt.title(f"{title} - Step {i+1}")
        plt.pause(speed)   # controlled speed
        plt.clf()

plt.ion()  # interactive mode
plot_steps(steps_bubble, "Bubble Sort")
plot_steps(steps_selection, "Selection Sort")
plot_steps(steps_insertion, "Insertion Sort")
plt.ioff()
plt.show()
