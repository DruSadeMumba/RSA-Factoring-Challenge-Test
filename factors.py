import sys

def factorize(n):
    i = 2
    while i * i <= n:
        if n % i == 0:
            return i, n // i
        i += 1
    return None, None

def main(file_path):
    with open(file_path, 'r') as f:
        numbers = f.read().splitlines()

    for num_str in numbers:
        num = int(num_str)
        p, q = factorize(num)
        if p is not None and q is not None:
            print(f"{num}={p}*{q}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python script.py input.txt")
        sys.exit(1)
    file_path = sys.argv[1]
    main(file_path)

