How to setup:

- Create a matching directory Structure

  ****.commands.subcommands

- Copy the CommandManager and CommandStruct classes to commands dir

- Coppy the ExampleCommand class to subcommands

- Add command lable to main
  Objects.requireNonNull(getCommand("comamndLable")).setExecutor(new CommandManager());


Commands can be easily created using the example command as a template

To create new commands:

- Create command in subcommands dir

- extend CommandStruct

- Fill in required fields

- Put command logic in commandRun method
  Player can be gotten from commandSender

- Add the command to plugin YML

- Add the command to CommandManager method in CommandManager class

- If you are using the module to use commands as /commanName <args> rather than /<name> <commandName> <args> you need to register your commands in onEnable using
  Objects.requireNonNull(getCommand("examplecommand")).setExecutor(new CommandManager());

