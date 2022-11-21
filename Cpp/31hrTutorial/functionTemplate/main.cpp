#include <cstring>
#include <iostream>

template <typename T>
T max(T a, T b)
{
    return (a > b) ? a : b;
}

// function template specialization
template <>
const char* max<const char*>(const char* a, const char* b)
{
    return (std::strcmp(a, b) < 0) ? b : a;
}

int main(int argc, char const* argv[])
{
    std::cout << max(1, 2) << std::endl;
    std::cout << max(12.5, 21.1) << std::endl;

    // force type: explicit template argument
    max<double>(3, 2.1);
}