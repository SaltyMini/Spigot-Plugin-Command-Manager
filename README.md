How to setup:

- Create a matching directory Structure

  ****.commands.subcommands

- Copy the CommandManager and CommandStruct classes to commands dir

- Coppy the ExampleCommand class to subcommands



Commands can be easily created using the example command as a template

To create new commands:

- Create command in subcommands dir

- extend CommandStruct

- Fill in required fields

- Put command logic in commandRun method
  Player can be gotten from commandSender

- Add the command to plugin YML

- Add the command to CommandManager method in CommandManager class
