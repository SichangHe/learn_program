defmodule HiPhx.Repo do
  use Ecto.Repo,
    otp_app: :hi_phx,
    adapter: Ecto.Adapters.Postgres
end
