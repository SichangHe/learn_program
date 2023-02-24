defmodule IslandsInterfaceWeb.UserSocket do
  use Phoenix.Socket

  channel "game:*", IslandsInterfaceWeb.GameChannel
end
