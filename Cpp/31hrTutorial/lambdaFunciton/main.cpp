#include <iostream>

int main(int argc, char const* argv[])
{
    // assign lambda function to a variable
    auto func = []() {
        std::cout << "hey" << std::endl;
    };
    func();

    // calling lambda function directly
    [](auto s) {
        std::cout << s << std::endl;
    }("hey");

    // [] include capture value
    auto a { 0 };
    auto b { 1 };
    std::cout << [a, b]() { return a + b; }() << std::endl;

    // capture by reference
    [&a]() { a++; }();
    std::cout << a << std::endl;

    // capture everything
    [=]() {
        std::cout << a << b << std::endl;
    }();
}