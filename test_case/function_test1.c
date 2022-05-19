int a;
int bd;

int main(char args) {
    int result;

    bd = -23;
    a = args + bd / 2;
    if ((bd / 2) == 0) {
        result = -1;
    }
    else {
        result = bd + a;
    }

    return result;
}