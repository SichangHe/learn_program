#include <iostream>

void inc(int* a);

int main(int argc, char const* argv[])
{
    auto a { 0 };
    std::cout << a << std::endl;
    inc(&a);
    std::cout << a << std::endl;
}

void inc(int* a)
{
    (*a)++;
}
