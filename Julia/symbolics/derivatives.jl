using Symbolics


# Helper.
p = println

# Declare symbols.
@variables x y

# Construct function.
f(x, y) = x^3 + y^3 + 3x * y^2 - 15x - 15y
p("f: $f")

d_over_dx = Differential(x)
p("d/dx: $d_over_dx")
d_over_dy = Differential(y)
p("d/dy: $d_over_dy")

df_over_dx = d_over_dx(f(x, y))
p("df/dx: $df_over_dx")
df_over_dy = d_over_dy(f(x, y))
p("df/dy: $df_over_dy")

# Convert to symbolic form
df_over_dx_formula = expand_derivatives(df_over_dx)
p("df/dx: $df_over_dx_formula")
df_over_dy_formula = expand_derivatives(df_over_dy)
p("df/dy: $df_over_dy_formula")
