for T in [Int8, Int16, Int32, Int64, Int128, UInt8, UInt16, UInt32, UInt64, UInt128, Float16, Float32, Float64]
    println("$(lpad(T,7)): [$(typemin(T)), $(typemax(T))]")
end