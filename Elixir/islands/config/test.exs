import Config

# We don't run a server during test. If one is required,
# you can enable the server option below.
config :islands_interface_web, IslandsInterfaceWeb.Endpoint,
  http: [ip: {127, 0, 0, 1}, port: 4002],
  secret_key_base: "1EEFuI3UxVyYUy6pfreihSIp+QWR9MGsOTG39znwYT7ptb+CTSTpePPZdAQ6nznR",
  server: false

# Print only warnings and errors during test
config :logger, level: :warn

# In test we don't send emails.
config :islands_interface, IslandsInterface.Mailer, adapter: Swoosh.Adapters.Test

# Initialize plugs at runtime for faster test compilation
config :phoenix, :plug_init_mode, :runtime
