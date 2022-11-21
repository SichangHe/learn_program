#include <stdio.h>

int main(int argc, char const* argv[])
{
    // old way to declare struct
    struct point {
        int x;
        int y;
    };
    struct point p;
    p.x = 10;
    p.y = 5;
    printf("%d", p.x);

    // new way using typedef
    typedef struct {
        int x;
        int y;
    } point;
    point p1;
    p1.x = 1;
    printf("%d", p1.y);

    return 0;
}
