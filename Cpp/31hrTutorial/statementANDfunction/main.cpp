#include <iostream>

int add(int m, int n) // have to put before main()
{
    return m + n;
}

int main()
{
    int n1{13};
    int n2{7};
    int sum{add(n1, n2)};

    std::cout << "first num: " << n1 << std::endl;
    std::cout << "second num: " << n2 << std::endl;
    std::cout << "sum: " << sum << std::endl;

    std::cout << "also: sum: " << add(n1, n2) << std::endl;
}
