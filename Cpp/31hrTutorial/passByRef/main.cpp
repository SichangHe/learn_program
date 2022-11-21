#include <iostream>

void inc(auto& a);

int main(int argc, char const* argv[])
{
    auto a { 0 };
    std::cout << a << std::endl;
    inc(a);
    std::cout << a << std::endl;

    auto b { 3.4 };
    std::cout << b << std::endl;
    inc(b);
    std::cout << b << std::endl;
}

void inc(auto& a)
{
    a++;
}