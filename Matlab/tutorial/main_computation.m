function [] = main_computation()
    a = [0.86, 0.9, 0.62, 0.62];
    b = [0.71, 0.81, 0.97, 1.03];

    for index = 1:4
        subplot(2, 2, index), plot(compute_result(a(index), b(index), 100));
        xlabel('n');
        ylabel('y(n)');
        title(sprintf('a=%g,b=%g', a(index), b(index)));
    end

end

function [y] = compute_result(a, b, points)
    y = zeros(1, points);
    % init
    y(1) = 0;
    y(2) = 0.5;

    % compute
    for n = 3:points
        y(n) = dot([y(n - 1), y(n - 2)], [2 * a, -b]);
    end

end
