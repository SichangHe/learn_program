#include <stdio.h>

int main(int argc, char** argv)
{
    int nums[5];
    nums[0] = 1;
    nums[1] = 2;
    nums[2] = 3;
    nums[3] = 4;
    printf("nums[3] is %d\n", nums[3]);
    printf("nums[4] is %d\n", nums[4]); // try reading uninitialized
    printf("nums[5] is %d\n", nums[5]); // try reading not owned
    return 0;
}