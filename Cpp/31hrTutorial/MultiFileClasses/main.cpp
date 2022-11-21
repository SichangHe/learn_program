#include "cylinder.h"
#include "squareCylinder.h"
#include <iostream>

int main(int argc, char const* argv[])
{
    Cylinder c {};
    std::cout << c.volume() << std::endl;
    // std::cout << c.height << std::endl; // err

    Cylinder c1(2, 3);
    std::cout << c1.volume() << std::endl;
    std::cout << c1.location() << std::endl;

    Cylinder* c2 { new Cylinder(3, 4) }; // allocate on the heap
    std::cout << (*c2).volume() << std::endl;
    std::cout << c2->volume() << std::endl; // alternative: pointer call operator

    delete c2;

    SquareCylinder c3(2);
    std::cout << c3.volume() << std::endl;
}