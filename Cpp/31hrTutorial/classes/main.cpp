#include <iostream>
const auto PI { 3.1415926535897 };

class Cylinder {
    // private
    double base_radius {};
    double height {};

public:
    /*
    Cylinder()
    {
        base_radius = 1.0;
        height = 1.0;
    }
    */

    // default constructor
    Cylinder() = default;

    Cylinder(auto radius, auto the_height)
    {
        base_radius = radius;
        height = the_height;
    }

    auto volume()
    {
        return PI * base_radius * base_radius * height;
    }

    // will be public until using `private:`
};

int main(int argc, char const* argv[])
{
    Cylinder c {};
    std::cout << c.volume() << std::endl;
    // std::cout << c.height << std::endl; // err

    Cylinder c1(2, 3);
    std::cout << c1.volume() << std::endl;
}