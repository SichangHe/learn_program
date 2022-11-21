int give_two()
{
    return 2;
}

int main()
{
    int ZERO {};
    int FIVE { 5 };
    int TWO { give_two() };
    int THREE(3.42);

    unsigned int POSITIVE_ONE { 1 };

    long long GOOGLE { 1e30L };

    float POINT_ONE { 0.1f };
    double POINT_THREE { 0.3 };

    bool TRUE { true };

    char A { 65 };
    int SIXTY_FIVE { static_cast<int>(A) };

    auto E { 'E' };
    auto FOUR { 4 };
    auto POSITIVE_TWO { 2u };
    auto AUTO_GOOGLE { 1e30L };

    const auto TEN { 10 };
}