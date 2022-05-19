int a;
int b;
int res;
int i;

int fib(int n) {
    res = 0;
    i = 2;
    a = 0;
    b = 1;

    while(i < n) {
        res = a + b;
        a = b;
        b = res;

        i = i + 1;
    }

    return i;
}