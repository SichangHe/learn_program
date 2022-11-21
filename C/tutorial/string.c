#include <stdio.h>

int main(int argc, char const* argv[])
{
    // modifiable string
    char hello[] = "LOL";
    printf("%s\n", hello);
    hello[2] = 'A';
    printf("%s\n", hello);
    // readonly string
    char* hey = "WTF";
    printf("%s\n", hey);
    hey[1] = 'O'; // crash
    return 0;
}
