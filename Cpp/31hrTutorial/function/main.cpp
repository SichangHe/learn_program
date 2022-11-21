// function declaration, or prototype
// has to be put before the definition
int max(int, int);

int main(int argc, char const* argv[])
{
    ;
}

// definition
int max(int num1, int num2)
{
    return num1 * (num1 > num2) + num2 * !(num1 > num2);
}
