package ver_01.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//** Instance of a single game **\\
public class Game implements Serializable {

    private int numMoves;
    private int currentNumMoves;
    private boolean gameWon;
    private Tower t1;
    private Tower t2;
    private Tower t3;
    private Tower[] towers;
    private int numBlocks;
    private List<Block> blockList;
    private List<State> stateList;
    private State currentState;

    //** Constructor **\\
    public Game(int numBlocks) {

        this.numBlocks = numBlocks;
        numMoves = 0;
        currentNumMoves = 0;
        blockList = new ArrayList<>();
        stateList = new ArrayList<>();
        gameWon = false;
        t1 = new Tower(1);
        t2 = new Tower(2);
        t3 = new Tower(3);
        towers = new Tower[3];
        towers[0] = t1;
        towers[1] = t2;
        towers[2] = t3;
        start();
    }

    public Game(State state) {

        numBlocks = state.getNumBlocks();
        numMoves = state.getNumMoves();
        currentNumMoves = 0;
        stateList = new ArrayList<>();
        gameWon = false;
        t1 = new Tower(1);
        t2 = new Tower(2);
        t3 = new Tower(3);
        towers = new Tower[3];
        towers[0] = t1;
        towers[1] = t2;
        towers[2] = t3;
        stateList.add(state);
        resetMove(state);
    }

    private void start() {
        currentState = normalState();
    }

    public State normalState() {

        t1.getList().clear();
        t2.getList().clear();
        t3.getList().clear();

        for (int i = 0; i < numBlocks; i++) {

            Block block = new Block (i * 0.5, i);
            towers[0].getList().add(block);
            blockList.add(block);
        }

        State state = new State(t1, t2, t3, numMoves, numBlocks);
        stateList.add(state);
        state.printState();
        return state;
    }

    //** Method will check if move is legal **\\
    public boolean moveBlock(int from, int to) {

        Block bFrom = towers[from].getList().get(towers[from].getList().size() -1);
        if (towers[to].getList().size() > 0) {
            Block bTo = towers[to].getList().get(towers[to].getList().size() -1);
            if (bTo.getSize() > bFrom.getSize()) {
                return false;
            }
        }
        towers[from].getList().remove(bFrom);
        towers[to].getList().add(bFrom);
        numMoves++;
        currentNumMoves++;
        if (checkWon()) {
            gameWon = true;
        }
        State state = new State(t1, t2, t3, numMoves, numBlocks);
        stateList.add(state);
        currentState = state;
        state.printState();
        return true;
    }

    //** Check if the game was won **\\
    public boolean checkWon() {
        return t2.getList().size() == numBlocks;
    }

    //** Return tower based on ID **\\
    public List<Block> getTowerList(int id) {
        return towers[id].getList();
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public void resetMove() {

        if (currentNumMoves < 1 || gameWon) {
            return;
        }
        State state = stateList.get(stateList.size() - 2);
        resetMove(state);

        stateList.remove(stateList.size() - 1);
        currentNumMoves --;
    }

    public void resetMove(State state) {

        t1.getList().clear();
        t1.getList().addAll(state.getT1Blocks());

        t2.getList().clear();
        t2.getList().addAll(state.getT2Blocks());

        t3.getList().clear();
        t3.getList().addAll(state.getT3Blocks());
        numMoves = state.getNumMoves();
    }

    public State getCurrentState() {
        return currentState;
    }
}