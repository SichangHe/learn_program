#include <stdio.h>
#include <stdlib.h>

typedef struct {
    char* name;
    int age;
} person;

int main(int argc, char const* argv[])
{
    person* p = malloc(sizeof(person));
    p->name = "Q";
    p->age = 0;
    printf("%s is %d years old.\n", p->name, p->age);
    return 0;
}
