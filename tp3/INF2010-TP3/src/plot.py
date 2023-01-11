import os
import argparse
try:
    import matplotlib.pyplot as plt
    import numpy as np
except ImportError as e:
    os.system(f"pip3 install {e.name}")
    print("Retry now")
    exit(1)

def str_to_floats(comma_separated_list):
    return [float(x) for x in comma_separated_list.split(',')]

def parse_args():
    parser = argparse.ArgumentParser(description='Plot in X and Y')
    parser.add_argument('-c', '--caller', type=str,
                        default='',
                        help='Name of the tested class')
    parser.add_argument('-x', type=str_to_floats,
                        help='Comma separated floats for x coords')
    parser.add_argument('-y', type=str_to_floats,
                        help='Comma separated floats for y coords')

    return parser.parse_args()


if __name__ == "__main__":
    args = parse_args()

    # Plot trend line
    print(np.polyfit(args.x, args.y, 1, full=True))
    trend, bias = np.polyfit(args.x, args.y, 1)
    p = np.poly1d((trend, bias))
    plt.plot(args.x, p(args.x), "r--", label=f"Trend: f(x) = {trend:.2f}x + {bias:.2f}")

    # Plot actual data
    plt.plot(args.x, args.y, label="Experiment") 
    plt.xlabel('Java Implementation Time')
    plt.ylabel("Own Implementation Time")
    plt.title(f'[{args.caller}] Complexity Comparison, should be a straight line')
    plt.legend()
    plt.show()
