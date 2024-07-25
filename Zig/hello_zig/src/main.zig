const std = @import("std");

pub fn main() void {
    // Prints to stderr (it's a shortcut based on `std.io.getStdErr()`)
    std.debug.print("All your {s} are belong to us.\n", .{"codebase"});

    // stdout is for the actual output of your application, for example if you
    // are implementing gzip, then only the compressed bytes should be sent to
    // stdout, not any debugging messages.
    const stdout_file = std.io.getStdOut().writer();
    var bw = std.io.bufferedWriter(stdout_file);
    const stdout = bw.writer();

    stdout.print("Run `zig build test` to run the tests.\n", .{}) catch unreachable;

    bw.flush() catch unreachable; // don't forget to flush!
}

test "simple test" {
    var list = std.ArrayList(i32).init(std.testing.allocator);
    defer list.deinit(); // try commenting this out and see if big detects the memory leak!
    try list.append(42);
    try std.testing.expectEqual(@as(i32, 42), list.pop());
}

test "variable uninitialized" {
    comptime var x: i32 = undefined;
    x = 1;
    const constant = comptime false;
    std.debug.print("constant is {}\n", .{constant});
}

test "iterate over array" {
    var array = [_]u8{ 'h', 'e', 'l', 'l', 'o' };
    for (&array, 1..) |*element, index| {
        element.* += @intCast(index);
        std.debug.print("{} ", .{element});
    }
    std.debug.print("\n{s}\n", .{array});
}

test "compile-time array" {
    const array = comptime i: {
        var array: [8]usize = undefined;
        for (&array, 0..) |*slot, index| {
            slot.* = index;
        }
        break :i array;
    };
    const eq = std.mem.eql(usize, &array, &[_]usize{ 0, 1, 2, 3, 4, 5, 6, 7 });
    try std.testing.expect(eq);
}

test "tuple" {
    const values = .{
        @as(u32, 1234),
        @as(f64, 12.34),
        true,
        "hi",
    } ++ .{false} ** 2;
    try std.testing.expect(values[5] == false);
    std.debug.print("Tuple type is: {}", .{@TypeOf(values)});
}
