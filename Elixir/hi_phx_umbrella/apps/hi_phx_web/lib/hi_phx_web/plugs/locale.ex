defmodule HiPhxWeb.Plugs.Locale do
  @moduledoc """
  Append locale to connection.
  If locale is not `en`, `fr`, or `de`, use default locale.
  """
  import Plug.Conn
  @locales ["en", "fr", "de"]
  def init(default) do
    default
  end

  def call(%Plug.Conn{params: %{"locale" => locale}} = conn, _default) when locale in @locales do
    assign(conn, :locale, locale)
  end

  def call(conn, default) do
    assign(conn, :locale, default)
  end
end
