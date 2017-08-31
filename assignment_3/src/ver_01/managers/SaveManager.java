package ver_01.managers;

import ver_01.FileManager;
import ver_01.model.State;

//** Class will write state out and read it back in **\\
public class SaveManager {

    private State savedGame;

    //** When initialised, will read from file **\\
    public SaveManager() {
        savedGame = FileManager.readIn();
    }

    //** Saving game **\\
    public void saveGame() {
        FileManager.writeOut(savedGame);
    }

    public State getSavedGame() {
        return savedGame;
    }

    public void setSavedGame(State savedGame) {
        this.savedGame = savedGame;
    }
}
