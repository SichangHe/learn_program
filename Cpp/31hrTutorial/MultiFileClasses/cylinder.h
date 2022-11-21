#ifndef CYLINDER_H // ensure this is not included twice
#define CYLINDER_H

#include <iostream>

const auto PI { 3.1415926535897 };

class Cylinder {
    // // private
    // double base_radius {};
    // double height {};

protected: // so derived classes can access
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

    Cylinder(auto radius, auto height)
    {
        base_radius = radius;
        this->height = height;
    }

    auto volume()
    {
        return PI * base_radius * base_radius * height;
    }

    // the `this` pointer points to object itself
    auto location()
    {
        return this;
    }

    // destructor
    ~Cylinder()
    {
        // normally, need to delete heap-allocated stuff here
        std::cout << "destructing" << std::endl;
    }

    // will be public until using `private:`
};

#endif