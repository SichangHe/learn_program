#include <iostream>

int main(int argc, char const* argv[])
{
    int var { 2 };
    int* p_var { &var };
    int* p_null {};

    std::cout << p_var << std::endl;
    std::cout << p_null << std::endl;
    std::cout << "dereference: " << *p_var << std::endl;

    int* p_num { new int(1) }; // allocated on heap
    std::cout << p_num << std::endl;
    std::cout << *p_num << std::endl;
    delete p_num; // delete the pointed, not the pointer
}