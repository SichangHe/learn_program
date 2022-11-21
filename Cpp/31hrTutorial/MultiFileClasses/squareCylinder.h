#ifndef SQUARE_CYLINDER_H
#define SQUARE_CYLINDER_H

#include "cylinder.h"

class SquareCylinder : public Cylinder { // public inheritance
public:
    SquareCylinder(auto length)
    {
        base_radius = length;
        height = length;
    }
};

#endif