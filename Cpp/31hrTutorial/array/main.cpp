#include <iostream>

int main(int argc, char const* argv[])
{

    int array[10];
    std::cout << array[0] << std::endl;
    std::cout << array[1] << std::endl;
    std::cout << array[2] << std::endl;

    array[0] = 1;

    std::cout << array[0] << std::endl;
    std::cout << array[1] << std::endl;
    std::cout << array[2] << std::endl;

    int array1[] { 0, 1, 2, 3 };
    for (size_t i = 0; i < std::size(array1); i++) {
        std::cout << array1[i] << std::endl;
    }

    for (auto i : array) {
        std::cout << i << std::endl;
    }

    char message[] { "hey" };
    std::cout << message << std::endl;

    char illegal[] { 'i', 'l', 'l' };
    std::cout << illegal << std::endl;

    char legal[] { 'l', 'e', 'g', 'a', 'l', '\0' };
    std::cout << legal << std::endl;

    char also_legal[4] { 'y', 'e', 's' };
    std::cout << also_legal << std::endl;
}
