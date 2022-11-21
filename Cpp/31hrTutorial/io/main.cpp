#include <iostream>

int main()
{
    std::string line;
    std::cout << "the next line will be recorded" << std::endl;
    std::getline(std::cin, line);
    std::cout << line << std::endl;

    int number;
    std::string str;

    std::cout << "give me a number and a string" << std::endl;
    std::cin >> number >> str;
    std::cout << "the number is " << number << " and the string is " << str << std::endl;

    std::cerr << "error message\n";
    std::clog << "log message\n";
}