# MasterMind + patterns
Project for third week. Starting with the sample code provided, we will follow the steps in [this project Klondike](https://github.com/iraticasi/klondike). Specifically, we should:

1. Allow users to undo/redo. For this, we will use the following design patterns:
    * _Memento_, to be able to store and load the state of a Game.
    * _Composite_, to create a new Controller which is based on other controllers.
    * _Command_, because in addition to undo/redo we have also added support for a simple Menu, whose actions will be represented as commands.
2. Add support to use a client/server architecture:
    * _Prototype_, to help the server get each dispatcher for the requests.
    * _Proxy_, to allow the main class, `MasterMind`, to work with a Logic class regardless of it's implementation: proxy or local based.
3. Let the user store the game:
    * _DAO_, to hide the specifics of how the game is saved.
