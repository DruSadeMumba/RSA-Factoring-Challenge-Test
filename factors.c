#include <stdio.h>
#include <stdlib.h>

void factorize(long long n) {
    long long i = 2;
    while (i * i <= n) {
        if (n % i == 0) {
            printf("%lld=%lld*%lld\n", n, n / i, i);
            return;
        }
        i++;
    }
    printf("%lld is a prime number.\n", n);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: ./factors <testfile>\n");
        return 1;
    }

    FILE *file = fopen(argv[1], "r");
    if (file == NULL) {
        perror("Error opening the file");
        return 1;
    }

    char buffer[256];
    while (fgets(buffer, sizeof(buffer), file)) {
        long long num = atoll(buffer);
        factorize(num);
    }

    fclose(file);
    return 0;
}

